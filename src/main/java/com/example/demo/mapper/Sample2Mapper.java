package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

public interface Sample2Mapper {

    @Insert("insert into tbl_sample2 (col2) values (#{data})")
    public int insertCol2(String data);
}
