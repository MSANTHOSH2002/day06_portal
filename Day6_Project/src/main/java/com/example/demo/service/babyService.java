package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.child;
import com.example.demo.respository.babyRepo;

@Service
public class babyService {
@Autowired
babyRepo br;
public List<child> saveAllInfo(List<child> ch)
{
	return (List<child>)br.saveAll(ch);
}
public List<child> getInfo()
{
	return br.findAll();
}
public  List<child> sortInfo(String field)
{
	return br.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
}
public List<child> getByPage(int pgno,int pgsize)
{
	Page<child> p = br.findAll(PageRequest.of(pgno, pgsize));
	return p.getContent();
}
public List<child> getPages(int pgno,int psize,String id)
{
	Sort ord=Sort.by(Sort.DEFAULT_DIRECTION,id);
	Page<child> b=br.findAll(PageRequest.of(pgno, psize,ord));
	return b.getContent();
}
}
