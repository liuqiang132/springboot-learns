package com.liuqiang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.entity.Book;
import com.liuqiang.mapper.BookMapper;
import com.liuqiang.service.BookService;
import com.liuqiang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class BookController {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;


    /**
     * 查询全部书籍
     * @return
     */
    @GetMapping("/findAll")
    public Result findBookAll(){
        List<Book> list = bookService.list();
        return Result.builder().flag(true).data(list).build();
    }
    /**
     * 根据id查询对应的书籍
     * @return
     */
    @GetMapping("/findOne/{id}")
    public Result findBookOne(@PathVariable("id") Integer id){
        Book book = bookMapper.selectById(id);
        if (book==null){
            return Result.builder().flag(false).data(null).build();
        }
        return Result.builder().flag(true).data(book).build();
    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/pageFindBook/{pageCurrent}/{pageSize}")
    public Result pageFindBook(@PathVariable("pageCurrent") Integer pageCurrent,
                               @PathVariable("pageSize") Integer pageSize
                                ){
        IPage<Book> page = new Page<>(pageCurrent,pageSize);
        IPage<Book> bookIPage = bookMapper.selectPage(page, null);
        return Result.builder().flag(true).data(bookIPage).build();
    }
    /**
     * 新增书籍
     * @return
     */
    @PostMapping("/insertBook")
    public Result insertBook(@RequestBody Book book){

        int insert = bookMapper.insert(book);
        if (insert==0){
            return Result.builder().flag(false).data(null).build();
        }
        return Result.builder().flag(true).data(insert).build();
    }
    /**
     * 更新书籍信息
     * @return
     */
    @PutMapping("/updateBook")
    public Result updateBook(@RequestBody Book book){
        //查询条件
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("id",book.getId());
        int update = bookMapper.update(book, wrapper);
        if (update==0){
            return Result.builder().flag(false).data(null).build();
        }


        return Result.builder().flag(true).data(update).build();
    }
    /**
     * 删除书籍信息
     * @return
     */
    @DeleteMapping("/deleteBook/{id}")
    public Result deleteBook(@PathVariable("id") Integer id){

        int deleteById = bookMapper.deleteById(id);
        if (deleteById==0){
            return Result.builder().flag(false).data(null).build();
        }
        return Result.builder().flag(true).data(deleteById).build();
    }

}
