package com.example.librarymanagementsystem.Service;


import java.util.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.librarymanagementsystem.Dto.BookDto;
import com.example.librarymanagementsystem.Entity.BookEntity;
import com.example.librarymanagementsystem.Respository.BookRepository;

@Service
public class BookService  {
    @Autowired
    private BookRepository br;
     @Autowired
    private ModelMapper modelMapper;

  //  private StudentRepository sr;
  public List<BookDto> findAll(){
    List<BookEntity> bb=this.br.findAll();
    List<BookDto> bdt=new ArrayList<>();
    for(BookEntity b: bb){
      BookDto bd=modelMapper.map(b, BookDto.class);
      bdt.add(bd);
    
    }
return bdt;
  }



    public BookDto byid(Long i){

        Optional<BookEntity> aa= this.br.findById(i);
        BookDto ad=new BookDto();
        ad.setBook_name(aa.get().getBook_name());
        return ad;
    }



//   public List<BookEntity> bookBorrowed(Integer stu_id){
//     Optional<StudentEntity> stu=sr.findById(stu_id);
//     return this.br.findByBorrowedBy(stu);
//   }

  public BookEntity save(BookEntity a){
        return this.br.save(a);
    }

}

