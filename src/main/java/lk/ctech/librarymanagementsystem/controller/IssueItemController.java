package lk.ctech.librarymanagementsystem.controller;

import lk.ctech.librarymanagementsystem.dto.ResponseDTO;
import lk.ctech.librarymanagementsystem.model.Book;
import lk.ctech.librarymanagementsystem.model.IssueItem;
import lk.ctech.librarymanagementsystem.service.BookService;
import lk.ctech.librarymanagementsystem.service.IssueItemService;
import lk.ctech.librarymanagementsystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library-management-system")
@CrossOrigin
public class IssueItemController {
    @Autowired
    private IssueItemService issueItemService;
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private BookService bookService;

    @PostMapping("/addIssueItem")
    public ResponseEntity addIssueItem(@RequestBody IssueItem issueItem) {
        Book bookInDB = bookService.searchBookById(issueItem.getBookId());
        int newCount = bookInDB.getQty() - 1;
        bookInDB.setQty(newCount);
        String result = bookService.updateBook(bookInDB);
        if (result.equals("00")){
                    try {
            String issueItemResult = issueItemService.addIssueItem(issueItem);
            if (issueItemResult.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(issueItem);
                            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (issueItemResult.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Registered issue item");
                responseDTO.setContent(issueItem);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("Error");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }else {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("Not have enough books");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/returnItem")
    public ResponseEntity returnItem(@RequestBody IssueItem issueItem){
        try {
            Book book = bookService.searchBookById(issueItem.getBookId());
            int qty = book.getQty();
            int newQty = ++qty;
            book.setQty(newQty);
            String result = issueItemService.removeIssueItemById(issueItem.getIssueId());
            if (result.equals("00")){
                bookService.updateBook(book);
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (result.equals("01")) {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Issue item not found");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NO_CONTENT);
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
