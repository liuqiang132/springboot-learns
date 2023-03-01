package com.liuqiang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.entity.Book;
import com.liuqiang.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
