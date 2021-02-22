# FindSubSetsofSet

Java ile yazdığım bu kodda, Herhangi bir dizinin (integer değerlerden oluşan) alt kümelerini bulup yazdırdım.
Bu kodun algoritması sadece integer dizinin alt kümelerini bulmak için değil, kodda yapılacak ufak değişikliklerle diğer veri tiplerinden oluşan dizilerinde alt kümelerini bulabiliriz.

Kodun algoritmasını anlatımı:

Yazdığım kodda girdi olarak {1,2,3,4,5} dizisini aldım.

bilindiği gibi herhangi bir kümenin alt küme sayısını 2^n (n = küme eleman sayısı) ile buluyorduk.

Find_SubSetNumber fonksiyonuyla bu değeri bulmuş oluyoruz.

![3](https://user-images.githubusercontent.com/49997690/108646862-41229a00-74c8-11eb-935b-f4d587c7db40.PNG)

Find_BinaryNumber fonksiyonuyla altküme bulma algoritmasına girebiliriz,

![4](https://user-images.githubusercontent.com/49997690/108646900-5eefff00-74c8-11eb-9b7f-ec89c4cee045.PNG)

5 elemanlı bir dizinin 32 tane alt kümesi vardır. 5 elemanlı diziden oluşabilecek alt kümelerden, herhangi bir alt kümenin eleman sayısının  olabileceği en az değer 0, en fazla 5 olur. Her kümenin boş bir alt kümesi vardır. en fazla 5 elemanlı alt kümesi ise kendisidir yani {1,2,3,4,5}.

algoritmanın mantığında, küme kaç elemanlıysa, o kadar uzunluktaki binary sayıları 0 dan 2^5 değerine kadar yazdırıp, değerleri ana kümeden almak var yani,

![1](https://user-images.githubusercontent.com/49997690/108646546-5519cc00-74c7-11eb-9c99-e066eea11cb3.PNG)

burada 1'den 32 ye kadar tüm sayıların binary gösterimi varıdr. fakat bu gösterimde dikkat ettiysek 1 değerini 00001 olarak gösterdik. burda 00001 olarak yani 5 elemanlı olarak göstermemizin sebebi aslında ana kümemizin eleman sayısının 5 olması. Örneğin {12,13,14,15,16,17,18} kümesinde 7 eleman vardır. yani 2^7=  128 alt kümesi vardır. eğer 1 sayısını üstteki görüntüdeki gibi göstermek istersek 0000001 olarak göstermeliyiz.

peki neden böyle gösteriyoruz. sebebi ise, 00001'den 11111 e kadar olan tüm sayılarda (31 tane sayı olur. 00000 boş kümeyi gösterir. algoritmaya elbette buda dahil), 1 olan indexleri, ana kümemizden eleman olarak çekip alt kümeleri oluşturmak.

![5](https://user-images.githubusercontent.com/49997690/108647815-9eb7e600-74ca-11eb-9dce-25aca931aafa.PNG)

ilk satırda görüldüğü gibi 00001 = 5 olarak gösterdim, çünkü 00001'de 1 olan indexler sadece 5. indextir. bizde ana kümenin 5. indexindeki değeri alıp, bundan alt küme oluşturacağız.

01010 = 4,2 olarak gösterdim. sebebi ise 2. ve 4. indexin değerleri 1. ana kümemizden 2. ve 4. indexteki değerli çekip bunlarla birlikte bir alt küme oluşturacağız.

en son satıra bakarsak, 00000 binary gösteriminde hiç 1 değeri yok. yani ana kümemizden çekebileceğimiz bir indexte yok. bu sebepten dolayı bu durum boş kümeyi gösterir.

şimdi farklı değerlerden oluşan başka bir örnek üzerinde inceleyelim,
burada ana kümemiz {44,66,77,33,22,11,88,99} olsun, 2^8 = 256 tane alt kümesi vardır.

sadece belli bir kısmı üzerinde inceleyelim,

![5](https://user-images.githubusercontent.com/49997690/108648424-41bd2f80-74cc-11eb-9909-69ed561fb66d.PNG)

satırlarda gördüğümüz gibi , ana kümemiz 8 elemanlı olduğu için binary sayılarımızıda 8 basamak olarak gösterdik.
ilk satırda, 1. 2. 3. 4. 5. ve 8. indexlerde eleman 1. yani ana kümemizden 1. 2. 3. 4. 5. ve 8. indexlerde bulunan değerleri çekip bir alt küme oluşturacağız. oluşturduğumuz alt küme ise {44,66,77,33,22,99} elemanlarından oluşur.
