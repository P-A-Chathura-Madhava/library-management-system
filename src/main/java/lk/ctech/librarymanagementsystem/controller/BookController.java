package lk.ctech.librarymanagementsystem.controller;

import lk.ctech.librarymanagementsystem.dto.ResponseDTO;
import lk.ctech.librarymanagementsystem.model.Book;
import lk.ctech.librarymanagementsystem.service.BookService;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library-management-system")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/saveBook")
    public ResponseEntity saveBook(@RequestBody Book book){
        try {
            String result = bookService.saveBook(book);
            if (result.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(book);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (result.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Registered Book");
                responseDTO.setContent(book);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("Error");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
