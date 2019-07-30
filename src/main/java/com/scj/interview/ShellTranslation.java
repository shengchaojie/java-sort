package com.scj.interview;

import java.io.*;
import java.util.*;

/**
 * 阿里笔试题
 * shell脚本模拟
 * 请用编程的方式实现以下shell脚本的功能
 *
 * cat /home/admin/logs/webx.log | grep "Login"| uniq lc | sort -nr
 * //找出包含login的，去重，排序
 * //读文件的函数可以用guava或者apache FileUtils，也可以自己实现
 * @author shengchaojie
 * @date 2019-07-29
 **/
public class ShellTranslation {

    public static void main(String[] args) throws IOException {
        List<String> logs = new ArrayList<String>();
        BufferedReader br = null;
        try{

            br = new BufferedReader(new InputStreamReader(ShellTranslation.class.getClassLoader().getResourceAsStream("log.txt")));
            String str;
            while((str = br.readLine())!=null){
                if(str.contains("Login")){
                    logs.add(str);
                }
            }
        }catch (IOException ex){
            //log.xxx
        }finally {
            if(br!=null) {
                br.close();
            }
        }

        HashMap<String,Integer> logSizeMap = new HashMap<String, Integer>();
        Map<Integer,Set<String>> logSizeSortMap = new TreeMap<>(Comparator.reverseOrder());
        for(String log : logs){
            Integer count = logSizeMap.get(log);
            if(Objects.isNull(count)){
                logSizeMap.put(log,1);
                Set<String> sortedLogs = logSizeSortMap.get(1);
                if(sortedLogs==null){
                    sortedLogs = new HashSet<>();
                }
                sortedLogs.add(log);
                logSizeSortMap.put(1,sortedLogs);
            }else{
                logSizeMap.put(log,count+1);
                Set<String> sortedLogs = logSizeSortMap.get(count);
                if(sortedLogs!=null && sortedLogs.size() > 0){
                    sortedLogs.remove(log);
                    sortedLogs = logSizeSortMap.get(count+1);
                    if(sortedLogs==null) {
                        sortedLogs = new HashSet<>();
                    }
                    sortedLogs.add(log);
                    logSizeSortMap.put(count+1,sortedLogs);
                }
            }
        }

        logSizeSortMap.entrySet().stream().forEach(a->{
            a.getValue().stream().forEach(b->{
                System.out.println(a.getKey() + " " + b);
            });
        });


    }

}
