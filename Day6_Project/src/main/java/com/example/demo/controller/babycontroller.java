package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.child;
import com.example.demo.service.babyService;

@RestController
public class babycontroller {
@Autowired
babyService bs;
@PostMapping("addBaby")
public List<child> saveAll(@RequestBody List<child> ch)
{
	return (List<child>)bs.saveAllInfo(ch);
}
@GetMapping("showBaby")
public List<child> getInfo()
{
	return bs.getInfo();
}
@GetMapping("sort/{name}")
public List<child> getSortInfo(@PathVariable String name)
{
	return bs.sortInfo(name);
}
@GetMapping("page/{pageno}/{pagesize}")
public List<child> showPageInfo (@PathVariable int pageno,@PathVariable int pagesize)
{
	return bs.getByPage(pageno, pagesize);
}
@GetMapping("sort")
public List<child> sortPage(@RequestParam(value="pNo")int pNo,@RequestParam(value="pSize")int pSize,@RequestParam(value="id")String id)
{
	return bs.getByPage(pNo, pSize);
}
}
