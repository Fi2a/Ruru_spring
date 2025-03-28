package com.bookSystem.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookSystem.DTO.BookBasketDto;
import com.bookSystem.DTO.BookListDto;
import com.bookSystem.DTO.BookLoanDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.BookWriteDto;
import com.bookSystem.Entity.Book;
import com.bookSystem.Entity.BookUse;
import com.bookSystem.Entity.MyBasket;
import com.bookSystem.Repository.BookRepository;
import com.bookSystem.Repository.MemberRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void bookSave(BookWriteDto bookWriteDto) {
		Book book = Book.of(bookWriteDto);
		bookRepository.save(book);
	}
	
	public List<BookListDto> bookSearch(BookSearchDto bookSearchDto) {

		List<BookListDto> bookListDtos = new ArrayList<>(); 
		
		List<Book> books = bookRepository.findByAll(bookSearchDto);
		
		for(Book book : books) {
			BookListDto bookListDto = new BookListDto(
					book.getBook_id(), book.getBook_title(), book.getBook_author(), book.getBook_publishing()
					);
			bookListDtos.add(bookListDto);
		}
		
		return bookListDtos;
	}
	
	// 도서 클릭하여 내 장바구니에 넣기
	// 클릭한 도서의 bookId 값을 받아야하고, 현재 로그인한 회원 id (번호) 가 필요
	public void myBasketSave(int bookId, String email) {
		
		Map<String, Integer> my = new HashMap<>();
		my.put("mid", memberRepository.findByEmail(email));
		my.put("bid", bookId);
		
		bookRepository.basketSave( my );
		
	}
			
	// 대출 메뉴 페이지에 내장바구니 도서 목록 띄우기
	// 현재 로그인 한 회원의 장바구니 목록 띄우기 -> 컨트롤로부터 로그인 정보 가져오기 ( 세션에 이메일이 저장되어있음 )	
	public List<BookBasketDto> myBasketList(String email){
		// 현재 로그인한 회원의 이메일을 통해 ID 가져오기
		int memberId = memberRepository.findByEmail(email);
		
		// 회원 ID와 일치하는 모든 데이터 조회 ( mybasket 테이블에서 )
		List<MyBasket> myBasketList = bookRepository.selectBasket(memberId);
		
		// 현재 로그인한 회원의 mybasket 에 있는 도서 번호 (book_id) 를 통해 도서정보 가져오기
		// 가지고 온 뒤 MyBasket 과 Book 객체의 데이터를 BookBasketDto 의 객체로 저장되게 만들기
		List<BookBasketDto> bookBasketDtos = new ArrayList<>(); 
		
		for(MyBasket temp : myBasketList) {
			
			Book book = bookRepository.findById( temp.getBook_id() );
			BookBasketDto bookBasketDto = BookBasketDto.of(temp, book);
			
			bookBasketDtos.add(bookBasketDto);
		}
		
		return bookBasketDtos;
	}
	
	// 도서목록 중 대출 클릭하면 book_use 에 저장
	public void loanSave(int id, int bookId, String email) {
		
		
		bookRepository.deleteBasket(id);
		
		Map<String, Integer> info = new HashMap<>();
		info.put("mid", memberRepository.findByEmail(email));
		info.put("bid", bookId);
		
		bookRepository.loanInsert( info );
	
}
	
	// 반납 메뉴 페이지에 대여중인 도서 목록 띄우기
	public List<BookLoanDto> myLoanList(String email){
		// 로그인 중인 회원 id
		int memberId = memberRepository.findByEmail(email);
		
		List<BookUse> myUseList = bookRepository.loanList(memberId);
		
		List<BookLoanDto> bookLoanDtos = new ArrayList<>();
		
		for(BookUse temp : myUseList) {
					
			Book book = bookRepository.findById( temp.getBook_id() );
			BookLoanDto bookLoanDto = BookLoanDto.of(temp, book);
					
			bookLoanDtos.add(bookLoanDto);
		}
		
		return bookLoanDtos;
	}
	
	// 반납했으면 book_use 변경하기
	public void returnSave(int id) {
		
		
		
		bookRepository.updateUses(id);
		
	}
	
	
	
	
}