# Втора лабораториска вежба по Софтверско инженерство


## Андријана Стајковска, бр. на индекс 124014


### Control Flow Graph
![cfg](https://github.com/AndrijanaStajkovska/SI_2023_lab2_124014/assets/18198851/e34a3260-9ba4-4eb6-9c45-1e2c51d88007)



### Цикломатска комплексност
Цикломатската комплексност на овој код изнесува 11 и истата ја добив со примена на формулата P+1. Односно P е бројот на предикатни јазли и иснесува 10. Па според тоа P+1 = 10+1 = 11.


### Тест случаи според Every Branch критериумот
![everybranch](https://github.com/AndrijanaStajkovska/SI_2023_lab2_124014/assets/18198851/d4722bdf-bd91-492f-b72e-7bf1a75cefe9)


За попрегледен приказ на тест случаите според Every Branch критериумот користиме матрица во која со ѕвезда се означени сите гранки кои се изминати за соодветнот тест, дедека пак со црвена боја се осначени гранките кои не се изминати за соодветниот тест.

- Со првиот тест се изминуваат поголемиот број на гранки. Овие гранки го исполнуваат условот да вредноста на username е null, password-от да е помал од 8 карактери и email-от да има точка и @.
   ```
   List<User> users = new ArrayList<>();
   String password1 = "12345";
   String email1 = "john.doe@hotmail.com";
   User user1 = new User(null, password1, email1);
   users.add(user1);
   assertEquals(false, SILab2.function(user1, users));
   ```

- Со вториот тест се изминуваат само гранките 1-2 и 2-end. Во овој тест случај функцијата фрла исклучок во јазолот 2 и поради тоа таа тука завршува, што значи дека е потребен нов тест случај за да се изминат останатите гранки.
   ```
   String username2 = "Alice";
   String password2 = "pass123@";
   String email2 = null;
   User user2 = new User(username2, password2, email2);
   users.add(user2);
   RuntimeException ex;
   ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
   assertTrue(ex.getMessage().contains("Mandatory information missing!"));
   ```

- Со третиот случај се изминуваат гранките 3-5, 6-16 и 22-28, со тоа што по изминување на гранката 22-28 функцијата завршува поради return statement-от кој се наоѓа во јазолот 28. Гранките 19-20 и 26-27 остануваат не изминати. Овој тест го исполнува барањето да pasword-от е поголем од 8 карактери, а email да нема точка и @.
   ```
   String username3 = "Jane";
   String password3 = "jane123AC!$";
   String email3 = "jane@yahoo.com";
   User user3 = new User(username3, password3, email3);
   users.add(user3);
   assertEquals(false, SILab2.function(user3, users));
   ```

- Со четвртиот и петтиот тест се изминуваат гранките 19-20 и 26-27 сооедветно.

   тест4:
   ```
    String username4 = "Ani";
    String password4 = "987";
    String email4 = "ani@gmail.com";
    User user4 = new User(username4, password4, email4);
    users.add(user4);
    assertEquals(false, SILab2.function(user4, users));
   ```
   тест5:
   ```
    String username5 = "David";
    String password5 = "532$bvcprw";
    String email5 = "adavid@gmail.com";
    User user5 = new User(username5, password5, email5);
    assertEquals(true, SILab2.function(user5, users));
   ```

### Тест случаи според Multiple Condition критериумот
![multiplecondition](https://github.com/AndrijanaStajkovska/SI_2023_lab2_124014/assets/18198851/31cd673f-f527-49e9-b2d9-07370f12c64d)


1. user==null враќа TRUE, што значи дека другите случаи нема потреба да се проверуваат, односно условот е исполнет. (1-2)
   ```
   List<User> users = new ArrayList<>();
   User user1 = null;
   RuntimeException ex;
   ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
   assertTrue(ex.getMessage().contains("Mandatory information missing!"));
   ```
    
2. user==null враќа FALSE, сега тука се проверува user.getPassword()==null и дадениот тест ќе врати "true" со што наредниот израз нема потреба да се проверува, односно условот е исполнет. (1-2)
   ```
   User user2 = new User("John", null, "john.doe@hotmail.com");
   ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
   assertTrue(ex.getMessage().contains("Mandatory information missing!"));
   ```

3. user==null и user.getPassword()==null враќаат FALSE, па сега следно тука се проверува user.getEmail()==null, што со посочениот тест ќе врати TRUE. Дополнителни услови нема за проверување, што значи условот е исполнет. (1-2)
   ```
   User user3 = new User("John", "pass123", null);
   ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
   assertTrue(ex.getMessage().contains("Mandatory information missing!"));
   ```
  
4. кога сите услови враќаат FALSE условот не е исполнет со што јазолот 2 се прескокнува. (1-3)
   ```
   User user4 = new User("John", "Pass123#!", "john@gmail.com");
   assertTrue(SILab2.function(user4, users));
   ```
