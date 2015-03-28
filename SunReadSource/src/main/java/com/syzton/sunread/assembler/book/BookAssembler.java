package com.syzton.sunread.assembler.book;

import com.syzton.sunread.dto.book.BookDTO;
import com.syzton.sunread.dto.book.BookExtraDTO;
import com.syzton.sunread.model.book.Book;
import com.syzton.sunread.model.book.BookExtra;
import org.joda.time.DateTime;

/**
 * Created by jerry on 3/16/15.
 */
public class BookAssembler {

//    public Book fromDTOtoEntireBook(final BookDTO bookDTO,final CategoryRepository categoryRepository){
//
//        Set<Category> categorySet = new HashSet<>();
//
//        for(Long caId: bookDTO.getCategories()){
//            categorySet.add(categoryRepository.findOne(caId));
//        }
//
//        BookExtra extra = this.fromDTOToExtra(bookDTO);
//        extra.setCategories(categorySet);
//
//
//        Book book = this.fromDTOtoBookWithExtra(bookDTO);
//        book.setExtra(extra);
//        return book;
//    }


    public Book fromDTOtoBookWithExtra(final BookDTO bookDTO){



        BookExtra extra = this.fromDTOToExtra(bookDTO.getExtra());

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setIsbn(bookDTO.getIsbn());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setCoin(bookDTO.getCoin());
        book.setDescription(bookDTO.getDescription());
        book.setPoint(bookDTO.getPoint());
        book.setPublicationDate(new DateTime(bookDTO.getPublicationDate()));
        book.setPictureUrl(bookDTO.getPictureUrl());
        book.setWordCount(bookDTO.getWordCount());
        book.setPageCount(bookDTO.getPageCount());
        book.setAuthorIntroduction(bookDTO.getAuthorIntroduction());
        book.setPrice(bookDTO.getPrice());
        book.setHighPrice(bookDTO.getHighPrice());
        book.setEvaluationNum(bookDTO.getEvaluationNum());
        book.setBinding(bookDTO.getBinding());

        book.setExtra(extra);


        return book;
    }

    public BookExtra fromDTOToExtra(final BookExtraDTO bookExtraDTO){
        BookExtra extra = new BookExtra();
        extra.setLanguage(bookExtraDTO.getLanguage());
        extra.setLevel(bookExtraDTO.getLevel());
        extra.setLiterature(bookExtraDTO.getLiterature());
        extra.setTestType(bookExtraDTO.getTestType());
        extra.setGrade(bookExtraDTO.getGrade());
        extra.setCategory(bookExtraDTO.getCategory());
        extra.setAgeRange(bookExtraDTO.getAgeRange());
        return extra;
    }
}
