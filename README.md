# 1.2- Herència i Polimorfisme - Nivell 1



Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". Aquesta classe 
té com a atributs una col·lecció de productes i el preu total de la venda.

La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada "VendaBuidaException" 
i mostra per pantalla “Per fer una venda primer has d’afegir productes” si la col·lecció de productes està buida. Si 
la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la suma de tots els preus dels productes a 
l’atribut preu total de la venda.

L’excepció personalitzada "VendaBuidaException" ha de ser filla de la classe Exception. Al seu constructor li hem de 
passar el missatge  “Per fer una venda primer has d’afegir productes” i quan capturem l’excepció, l’hem de mostrar per
pantalla amb el mètode getMessage() de l’excepció.

Escriu el codi necessari per a generar i capturar una excepció de tipus "IndexOutOfBoundsException";



## Tecnologies Utilizades
* Java
* IntelliJ
* Git

## Requisits
* Java 17
* IntelliJ (opcional)

## Instal·lació

1. Clona el repositori:
```
git clone https://github.com/mxg912/1.1_Herencia_Polimorfisme.git
```
2. Obre el projecte amb IntelliJ IDEA.

3. Executa la classe nivell1.app.Main.java.

## Execució

## Desplegament

## Contribucions
El projecte ignora .idea/ .out/  .iml i .repository_token.

1. Fes un fork del repositori
2. Crea una nova branca   git checkout -b feature/NovaFuncionalitat
3. Fes els teus canvis i commiteja'ls:   git commit -m 'Afegeix Nova Funcionalitat'
4. Puja els canvis a la teva branca:   git push origin feature/NovaFuncionalitat
5. Fes un pull request

## Autor
* @mxg912
