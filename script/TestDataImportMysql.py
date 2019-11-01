# -*- coding:utf-8 -*-

import os,sys,json
import time,datetime
import json,time
import pymysql
from datetime import datetime



#写数据库函数
def in_sql(Request_sequence,Request_from,Request_server,Request_host,Request_time,Request_method,Request_url,Request_params):
    print('Request_sequence： ', Request_sequence)
    print('Request_from： ', Request_from)
    print('Request_server： ', Request_server)
    print('Request_host： ', Request_host)
    print('Request_time： ', Request_time)
    print('Request_method： ', Request_method)
    print('Request_url： ', Request_url)
    print('Request_params： ', Request_params)

    print(sql)



if __name__ == '__main__':
    conn = pymysql.connect(host='127.0.0.1', port=int('3306'), user='root',passwd='zr179561', db='peek', charset="utf8")
    cursor = conn.cursor()

    fp = open('/Users/zengrui/Documents/access_test-52.log')
    lines = fp.readlines()
    fp.close()
    for i in range(len(lines)):
        print(lines[i])
        old = lines[i].split(' ')[1:]

        Request_sequence = i
        Request_from = old[0]
        Request_server = old[2]
        Request_host = old[1]
        Request_time = old[3][1:]
        Request_time = int(time.mktime(time.strptime(str(datetime.strptime(Request_time, '%d/%b/%Y:%H:%M:%S')),"%Y-%m-%d %H:%M:%S")))
        Request_method = old[5][1:]
        Request_url = old[6].split('?')[0]
        Request_params = old[6].split('?')[1].split('&xzsign')[0]
        timeArray = time.localtime(Request_time)
        otherStyleTime = time.strftime("%Y%m%d", timeArray)
        sql = """insert into requestinfo(Request_sequence, Request_from, Request_server, Request_host, Request_time, Request_method, Request_url,Request_params) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')""" % (\
        Request_sequence, Request_from, Request_server, Request_host, Request_time, Request_method, Request_url,\
        Request_params)
        cursor.execute(sql)

        in_sql(Request_sequence,Request_from,Request_server,Request_host,Request_time,Request_method,Request_url,Request_params)
    conn.commit()
    cursor.close()
    conn.close()







