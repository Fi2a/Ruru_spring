package com.bookSystem.DTO;

import com.bookSystem.Entity.Book;
import com.bookSystem.Entity.MyBasket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBasketDto {
	
	private int id;			// mybasket 테이블의 id 컬럼 값
	private int book_id;	// mybasket 테이블의 book_id 컬럼 값
	private String book_title;	// book 테이블의 book_title 컬럼 값
	private String book_author; // book 테이블의 book_author 컬럼 값
	
	public static BookBasketDto of(MyBasket myBasket, Book book) {
	
		BookBasketDto bookBasketDto = new BookBasketDto();
		bookBasketDto.setBook_id( myBasket.getBook_id() );
		bookBasketDto.setBook_author( book.getBook_author() );
		bookBasketDto.setBook_title( book.getBook_title() );
		bookBasketDto.setId( myBasket.getId() );
		
		return bookBasketDto;
	}
	
}
