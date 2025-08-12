# Spring AOP - Aspect-Oriented Programming

### url

> 1pQ5k5SqbZyoNJilrDF5cvRVDa0611FPvdB5ADKKPTpE

```
- AOP melengkapi OOP dalam membuat kode program.
- OOP => inti dari modularity kode adalah class
- AOP => inti dari modularity kode adalah aspect
- Aspect memungkinkan modularity daro concerns (perhatian), 
  yang bisa melintasi berbagai jenis tipe data dan object.
  
2 fitur OOP:
- Spring AOP sendiri
- Library AOP => AspectJ
```

## AspectJ

```
-AspectJ adalah libarary AOP yang banyak digunakan untuk implementasi AOP di Java.
```

> Contoh membuat kode prorgram tanpa AOP dulu (agar nanti tau perbedaannya).

```
1. Buat Service class
   package com.cahya.aop.service; => folder main
2. Buatkan package service dan class HelloServiceTest.java
   package com.cahya.aop.service; => folder test, class HelloServiceTest 
result setelah running = lognya sudah di panggil:
```

> ![img.png](img.png)

> Bayangkan jika method terus bertambah, kita harus membuat log terus secara manual.
> Apa yang harus dilakukan?
> > Lihat jika polanya sama, kita bisa gunakan AOP untuk mengatasi masalah ini.
> > AOP memungkinkan kita membuat Aspect yang melintasi semua method dari object tersebut.
> > Dimana di aspectnya, kita perlu MENULIS kode untuk log satu kali saja.

## Mengaktifkan AOP

```
- Default Spring Boot tidak mengaktifkan AOP.
- Untuk mengaktifkan AOP secara manual menggunakan annotation @EnableAspectJAutoProxy
- Kita bisa tambahkan do Bean Configuration agar fitur AOP aktif.
```

> Contoh: padaca class SpringAopApplication.java
> Tambahkan annotation @EnableAspectJAutoProxy
> Kemudian coba running unit test HelloServiceTest.java

## Aspect

```
- INTI dari AOP adalah Aspect.
- Sehingga kita harus membuat Aspect terlebih dahulu.
- Untuk membuat Aspect, 
  cukup membuat Bean dan menambahkan annotaton Aspect pada Bean tersebut.
- Otomatis Spring akan membuatkan object Aspect dari class tersebut.
```

> Contoh:
> > 1. Membuat class LogAspect.java, yang dijadikan bean dengan annotation @Component
> > 2. Dan jika ingin menjadikan class tersebut sebagai Aspect, tinggal tambahkan annotation @Aspect
> > 3. Step 1 dan 2 berada dalam pacakege aspect di class LogAspect.

```
- Secara default, Aspect tidak berguna jika tidak menambahkan behavior pada Aspect tersebut.
- Untuk menabahkan behaviour ke Aspect, dilakukan dengan menambhakan method pada Aspect tersebut.

Ketentukan method pada Aspect:
1. ada pointcut
2. ada advice
```

## Join Point - titik lokasi eksekusi program

```
- Joint point adalah titik lokasi eksekusi program.
-  AspectJ sebenarnya mendukung Join Point, 
   namun Spring AOP hanya mendukung Join Point pada method di bean.
```

> ![img_1.png](img_1.png)

## Pointcut

```
- Pointcut adalah predikat yang cocok dengan Join Point.
- Poincut merupakan kondisi yang digunakan untuk menentukan Join point.
- Ketika kondisi terpenuhi, maka Aspect akan mengeksekusi Advice.
- Untuk membuat pointcut, kita perlu menggunakan annotation @Pointcut.
- setiap membuat pointcut, kita harus menentukan kondisi Join Point yang akan digunakan.
```

> Contoh: di class LogAspect.java
> tambahkan method dengan annotation @Pointcut