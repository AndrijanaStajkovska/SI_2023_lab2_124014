# Андријана Стајковска, бр. на индекс 124014


### Control Flow Graph
![cfg](https://github.com/AndrijanaStajkovska/SI_2023_lab2_124014/assets/18198851/e5faab41-4150-49e2-83d1-25919540e25c)


### Тест случаи според Multiple Conditionion критериумот
![1](https://github.com/AndrijanaStajkovska/SI_2023_lab2_124014/assets/18198851/39a2cd0f-d7ff-435a-b1a2-3f27518b0ef8)

1. user==null враќа TRUE, што значи дека другите случаи нема потреба да се проверуваат, односно условот е исполнет. (1-2)
2. user==null враќа FALSE, сега тука се проверува user.getPassword()==null и дадениот тест ќе врати "true" со што наредниот израз нема потреба да се проверува, односно условот е исполнет. (1-2)
3. user==null и user.getPassword()==null враќаат FALSE, па сега следно тука се проверува user.getEmail()==null, што со посочениот тест ќе врати TRUE. Дополнителни услови нема за проверување, што значи условот е исполнет. (1-2)
4. кога сите услови враќаат FALSE условот не е исполнет и јазолот 2 се прескокнува. (1-3)
