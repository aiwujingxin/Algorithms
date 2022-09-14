./mvnw spring-boot:run

1.统计当前文件夹下文件的个数
ls -l |grep "^-"|wc -l
2、 统计当前文件夹下目录的个数
ls -l |grep "^d"|wc -l
3、 统计当前文件夹下文件的个数，包括子文件夹里的
ls -lR|grep "^-"|wc -l
4、统计文件夹下目录的个数，包括子文件夹里的
ls -lR|grep "^d"|wc -l
