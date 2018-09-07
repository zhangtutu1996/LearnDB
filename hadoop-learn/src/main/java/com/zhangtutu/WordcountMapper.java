package com.zhangtutu;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * KEYIN :	map task读取数据中key的类型，是一行的起始偏倚量（long）
 * VALUEIN :	map task读取数据中value的类型，是一行的内容（String）
 * KEYOUT：用户的自定义map方法返回kv数据的key的类型
 * VALUEOUT：用户的自定义map方法返回kv数据的value的类型
 * 
 * map 产生的数据传输到reduce需要序列化和反序列化
 *
 */
public class WordcountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] words = line.split(" ");
		for (String word : words) {
			context.write(new Text(word), new IntWritable(1));
		}

	}
}
