# DevvelaTestTask
Mvideo XML parser

1. Получить список товаров из products.xml. Сделать поле, чтобы можно было загрузить файл через веб.

2. Записать полученные данные в БД.


Для каждого товара записать поля: product_id, title, description, rating, price (если есть inet_price), image.
- Если в товаре отсутствует product_id, то это будет означать, что id товара такой же как предыдущий, но товар другой вариации 
- В зависимости от рейтинга товара добавить товар в одну из категорий:
	плохой (рейтинг <= 3)
	хороший ( 3 < рейтинг <= 4)
	отличный ( 4 < рейтинг <= 5)

3. Вывести данные (поля из предыдущего пункта) в таблице\гриде. 

Для данных сделать CRUD.
Сделать возможность сортировать записи в таблице по выведенным полям.
По клику на картинку или название товара - переходим на страницу товара.
На этой странице выводится вся имеющаяся информация по товару.
При создании/редактировании товара сделать валидацию вводимых данных в поле title - только кириллица, цифры и пробел

4. Сделать счетчик для кол-ва просмотров товара.

5. Вывести один график “Кол-во просмотров всех товаров по минутам”

Рекомендуется реализовать на фреймворке Grails.
Интерфейс рекомендуется сделать на Twitter Bootstrap.
Написать Readme файл.
Результат выложить на github (bitbucket) или прислать архивом с комментариями.

---------------------------------------------------------------------------------
Сделано все, кроме графика, ибо JavaScript, Google Charts и прочие вещи, как-нибудь время будет - вернусь.

P.S. Тестовое задание в компанию Devvela (Екатеринбург). Реализовано на Spring MVC. БД - PostgreSQL, ORM - Hibernate.  Ну и милости в виде AJAX и JQuery. Интерфейс, как и рекомендовано - Bootstrap.

P.P.S. Делать одинаковые ID для разных товаров - дикость. Я сам в М.Видео работал около 2 лет, нет там такого - ID "близких" товаров(разный цвет, например) отличаются на единицу.
В данном примере пришлось записывать baseId и productId, хотя можно было записывать только ИД продукта...
