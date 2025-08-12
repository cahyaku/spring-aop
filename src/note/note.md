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
