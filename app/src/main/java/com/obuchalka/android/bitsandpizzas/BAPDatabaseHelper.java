package com.obuchalka.android.bitsandpizzas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 16.11.2016.
 */

public class BAPDatabaseHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "bitsandpizzas";
	public static final int DB_VERSION = 2;

	BAPDatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		updateMyDB(db, 0, DB_VERSION);
	}

	private static void insert(SQLiteDatabase db, String tableName, String name,
	                           String description, int resourceId) {
		ContentValues values = new ContentValues();
		values.put("NAME", name);
		values.put("DESCRIPTION", description);
		values.put("IMAGE_RESOURCE_ID", resourceId);
		db.insert(tableName, null, values);
	}

	private void updateMyDB(SQLiteDatabase db, int oldV, int newV) {

		if (oldV < 1) {
			db.execSQL("CREATE TABLE PIZZA(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "NAME TEXT, "
					+ "DESCRIPTION TEXT, "
					+ "IMAGE_RESOURCE_ID INTEGER);");

			db.execSQL("CREATE TABLE PASTA(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "NAME TEXT, "
					+ "DESCRIPTION TEXT, "
					+ "IMAGE_RESOURCE_ID INTEGER);");

			db.execSQL("CREATE TABLE RESTAURANT(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "NAME TEXT, "
					+ "DESCRIPTION TEXT, "
					+ "IMAGE_RESOURCE_ID INTEGER);");
			insertPasta(db);
			insertPizza(db);

		}

		if (oldV < 2) {
			insertRestaurant(db);
		}

	}

	static void insertRestaurant(SQLiteDatabase db) {
		insert(db, "RESTAURANT", "Кэмбридж", "ул.Фрезировщиков 666б", 0);
		insert(db, "RESTAURANT", "Севастополь", "ул.Фрезировщиков 666б", 0);
	}

	static void insertPizza(SQLiteDatabase db) {
		insert(db, "PIZZA", "Пицца «Дьябола»",
				"привлекает любителей остренького – " +
						"сочетание салями и перца чили составляют основу этой пиццы.",
				R.drawable.pizza_diablo);
		insert(db, "PIZZA", "Пицца «Маргарита»",
				" пожалуй, самое именитое из своих сородичей, это блюдо является" +
						" и самым лаконичным в своем классе: " +
						"тесто, томатный соус, сыр моцарелла. Все. " +
						"Просто и нереально вкусно, если продукты, из которых готовят " +
						"«Маргариту», качественные и свежие.",
				R.drawable.pizza_margarita);
		insert(db, "PIZZA", "Пицца «Гавайская»",
				"вариант для тех, чье сердце начинает учащенно биться при слове «ананасы». " +
						"Добавьте к ним ветчину (опционально – куриное филе), сыр, " +
						"томатный соус – и получите как раз то, что надо: " +
						"американское «детище», знаменитую Pizza Hawaii.",
				R.drawable.pizza_gavai);
		insert(db, "PIZZA", "Пицца «Пепперони»",
				"Пицца «Пепперони» создана для тех, кто в восторге от горячих ощущений. " +
						"Само название однократно выдаёт незаменимый топпинг данного лакомства," +
						" безусловно, в ней Вы найдете острейшую колбасу пепперони.",
				R.drawable.pizza_pepperoni);
		insert(db, "PIZZA", "Пицца «Сицилийская»",
				"практически стандартный вариант с анчоусами, но с " +
						"одной характерной деталью: тесто для" +
						" нее обязательно раскатывают в виде квадрата.",
				R.drawable.pizza_sicilli);
		insert(db, "PIZZA", "Пицца «Маринара»",
				"родом из Неаполя, переводится как пицца «с соусом для моряков» и " +
						"совершенно не связана с морепродуктами." +
						" Она включает в себя непременный томатный соус," +
						" орегано, анчоусы и чесночок.",
				R.drawable.pizza_marinara);
		insert(db, "PIZZA", "Пицца «Капричоза»",
				"готовится с грибами, оливками, ветчиной и вареным яйцом.",
				R.drawable.pizza_kaprizzioza);
		insert(db, "PIZZA", "Пицца «Четыре сезона»",
				"разделена на 4 части, каждая из которых наполняется «своими» компонентами. " +
						"Зима хвастается грибами, весна – артишоками, " +
						"лето – сладким перцем, осень – свежими томатами.",
				R.drawable.pizza_fourseasons);
		insert(db, "PIZZA", "Пицца «Четыре сыра»",
				"включает в себя не менее 4-х видов сыра (обязательно – пармезан, " +
						"рикотта, моцарелла, горгонзолла), " +
						"обходится без томатного соуса и подается " +
						"с рукколой или базиликом.",
				R.drawable.pizza_fourcheese);
		insert(db, "PIZZA", "Пицца «Примавера»",
				"невозможна без орегано, яркие вкусовые " +
						"нотки которого сдержанно дополняют " +
						"сыр моцарелла, оливковое масло и томатный соус.",
				R.drawable.pizza_primavera);
		insert(db, "PIZZA", "Пицца «Карбонара»",
				"специально для тех, кому по душе бекон. Тонкие и обжаренные ломтики бекона," +
						" солнечный желток, нежный сыр и всё это в сочетании с классическим " +
						"соусом «Карбонара» создаёт бесподобный вкус и насыщенный аромат. " +
						"Конечно, не стоит забывать и про пышное тесто, " +
						"пропитанное классическим соусом и большим количеством сыра. " +
						"Это вкус, в который тяжело не влюбиться.",
				R.drawable.pizza_carbonara);
		insert(db, "PIZZA", "Пицца «Баварская»",
				"это пицца с пикантным вкусом.  " +
						"На основу мягкого и нежного теста наносят " +
						"фирменный ароматный соус, " +
						"придающий блюду не отменную сочность" +
						" и своеобразную насыщенность.",
				R.drawable.pizza_bavar);
	}

	static void insertPasta(SQLiteDatabase db) {
		insert(db, "PASTA", "Маникотти",
				"Это очень крупные трубочки, " +
						"обычно рифленые, которые фаршируют самой" +
						" разнообразной начинкой (морепродуктами, мясом, овощами), " +
						"а затем запекают, полив традиционным итальянским белым соусом " +
						"бешамель и присыпав тертым пармезаном. Несмотря на большой размер," +
						" маникотти — довольно легкое (и вкусное) блюдо.",
				R.drawable.pasta_1);
		insert(db, "PASTA", "Букатини",
				"Букатини — толстые макаронные изделия в виде спагетти с дыркой по центру. " +
						"Такие трубочки длиной 25-30 см обычно варят 9 минут, а затем подают с " +
						"масляными соусами, панчеттой (бекон) или гуанчиале, овощами, сыром, яйцами " +
						"и анчоусами или сардинами.",
				R.drawable.pasta_2);
		insert(db, "PASTA", "Тальятелле",
				"Тальятелле — длинные плоские «ленты», которые делают из яиц. Они имеют пористую" +
						" и грубую текстуру, что делает их идеальными для итальянских сосисок из" +
						" говядины, телятины, свинины или крольчатины. Еще одна популярная версия " +
						"тальятелле подается с трюфелями, оливками и овощами.",
				R.drawable.pasta_3);
		insert(db, "PASTA", "Равиоли",
				"По традиции, их готовят дома. Это своего рода пельмени. " +
						"Обычно они имеют квадратную" +
						" форму, хотя встречаются и круглые, и полукруглые. " +
						"Вид начинки варьируется " +
						"в зависимости от региона. В Риме, например, равиоли " +
						"фаршируют рикоттой, шпинатом, " +
						"мускатным орехом и черным перцем. " +
						"В Сардинии их фаршируют рикоттой " +
						"и тертой коркой лимона.",
				R.drawable.pasta_4);
		insert(db, "PASTA", "Джемелли",
				"В переводе с итальянского это название означает " +
						"«близнецы». Это крученая паста, которую " +
						"обычно подают с легкими соусами (например," +
						" песто), которые остаются на спиральках." +
						" Иногда джемелли называют «рога единорога». " +
						"Это идеальный выбор для салата или различных " +
						"типов томатных соусов.",
				R.drawable.pasta_5);
		insert(db, "PASTA", "Фарфалле",
				"Фарфалле переводится с итальянского как «бабочки», " +
						"и это один из самых популярных видов пасты." +
						" Они могут быть разных размеров, но всегда" +
						" имеют четкую форму бабочки. Хотя к ним " +
						"подойдут практически все соусы, лучше всего" +
						" подавать фарфалле со сливочными и томатными." +
						" Фарфалле бывают самыми разными — обычные, " +
						"томатные, со шпинатом. Обычно разные сорта " +
						"продаются вместе, в одной упаковке, " +
						"напоминая по цвету национальный флаг Италии.",
				R.drawable.pasta_6);
		insert(db, "PASTA", "Феттуччини",
				"Это название переводится как «маленькие ленточки». " +
						"Это плоская толстая лапша из яиц и муки. " +
						"Они похожи на тальятелле, но чуть шире. " +
						"Особенно популярны в римской кухне. " +
						"Зачастую феттуччини едят с говядиной и" +
						"ли куриным рагу. Однако самым популярным" +
						" блюдом с этим видом пасты является" +
						" «Феттуччини Альфредо», которое состоит " +
						"из феттуччини, пармезана и сливочного масла.",
				R.drawable.pasta_7);
		insert(db, "PASTA", "Фьори",
				"Этот вид прессованной пасты с " +
						"шестью «лепестками», окружающими центр," +
						" напоминает цветок. Часто используется" +
						" с салатами, но также отлично подходит " +
						"к мясным и рыбным соусам или соусам на " +
						"основе томатов.",
				R.drawable.pasta_8);
		insert(db, "PASTA", "Каннеллони",
				"Переводится как «большой тростник». " +
						"Это цилиндрический вид пасты, которую обычно " +
						"подают запеченной с начинкой и политой соусом. " +
						"Популярные начинки включают в себя шпинат и " +
						"рикотту или рубленую говядину. Обычно с этой" +
						" пастой используют томатный соус (снизу) и" +
						" бешамель (сверху).",
				R.drawable.pasta_9);
		insert(db, "PASTA", "Диталини",
				"Диталини напоминают очень короткие " +
						"макароны в форме маленьких " +
						"трубочек. Этот вид пасты типичен " +
						"для сицилийской кухни. Обычно это" +
						" один из главных ингредиентов салатов, " +
						"благодаря своему маленькому размеру, " +
						"однако они также добавляются в супы. " +
						"В основных блюдах диталини обычно подают " +
						"с рикоттой и брокколи.",
				R.drawable.pasta_10);
		insert(db, "PASTA", "Ротини",
				"Не путайте их с очень похожими внешне фусилли. " +
						"Ротини — это вид пасты в форме спирали " +
						"или штопора, если хотите. Благодаря своей " +
						"уникальной структуре, ротини добавляют блюду " +
						"больше аромата и вкуса, впитывая в себя больше " +
						"соуса. Часто их подают с песто, карбонарой или " +
						"соусами на основе томатов.",
				R.drawable.pasta_11);
		insert(db, "PASTA", "Лингуине",
				"Это длинная плоская лапша, шире, чем спагетти, и" +
						" примерно такая же, как феттуччини. " +
						"Впервые они появились в Генуе, а " +
						"подают их с песто или морепродуктами. " +
						"Обычно лингуине доступны как в варианте " +
						"из белой муки, так и в цельнозерновом варианте.",
				R.drawable.pasta_12);
		insert(db, "PASTA", "Конкилье",
				"Обычно их называют просто «ракушки» из-за их характерной формы." +
						" Особенно популярны в Британии." +
						" Этот тип пасты может быть самых разных цветов " +
						"— для их окраски используются натуральные" +
						" красители, такие как томатный экстракт, чернила " +
						"кальмара или экстракт шпината.",
				R.drawable.pasta_13);
		insert(db, "PASTA", "Радиатори",
				"Радиатори — маленькие короткие макаронные изделия," +
						" названные в честь радиаторов. Эта необычная форма" +
						" должна максимизировать площадь поверхности для " +
						"лучшего прилипания. Именно благодаря этой форме " +
						"паста отлично подходит для густых соусов, но ее" +
						" также можно найти в запеканках, салатах и супах.",
				R.drawable.pasta_14);
		insert(db, "PASTA", "Пичи",
				"Это толстая длинная паста, которая впервые появилась " +
						"в провинции Сиена в Тоскане. Тесто скатывают в" +
						" толстый плоский лист, нарезают полосками, а " +
						"затем вручную скатывают в крошечные длинные цилиндры, " +
						"чуть тоньше обычного карандаша. Пичи подают с разными" +
						" блюдами, в том числе с чесночно-томатным соусом, " +
						"грибным соусом, рагу и различным видам мяса.",
				R.drawable.pasta_15);
		insert(db, "PASTA", "Гарганелли",
				"Это тип пасты на яичной основе, которая знаменита тем," +
						" что ее нужно очень долго готовить. Гарганелли " +
						"сворачивают в форме трубочек, напоминающих пене. " +
						"Этот вид пасты типичен для болонской кухни, " +
						"а также его часто подают с утиным рагу.",
				R.drawable.pasta_16);
		insert(db, "PASTA", "Вермишель",
				"В переводе слово «вермишель» означает «маленькие червячки». " +
						"Это традиционный тип длинной тонкой пасты, похожий " +
						"на спагетти и хорошо известный всем нашим соотечественникам. " +
						"Хотя это один из самых традиционных видов итальянской пасты, " +
						"в некоторых азиатских странах есть свои собственные варианты " +
						"этого блюда из рисовой муки. Вермишель отлично подходит к " +
						"морепродуктам.",
				R.drawable.pasta_17);
		insert(db, "PASTA", "Каватаппи",
				"Каватаппи — завернутые спиральные трубочки, напоминающие скрученные " +
						"макароны. Это идеальный выбор для холодного салата, кроме того," +
						" этот вид макаронных изделий отлично пойдет как с легкими, так и " +
						"с плотными соусами.",
				R.drawable.pasta_18);
		insert(db, "PASTA", "Тортеллини",
				"Тортеллини впервые появились в итальянском регионе Эмилия. " +
						"Это кольцеобразные макаронные изделия с начинкой внутри. " +
						"Обычно их наполняют мясным фаршем (свинина, прошутто), " +
						"сыром и овощами (шпинатом), а подают с говяжьим или куриным " +
						"бульоном. Тортеллини — один из самых распространенных видов пасты.",
				R.drawable.pasta_19);
		insert(db, "PASTA", "Паппарделле",
				"Это большие и очень широкие макаронные изделия. В сыром виде их ширина " +
						"составляет 2-3 см и может иметь рифленые края. Паппарделле родом " +
						"из региона Тоскана и отлично подходят к томатным и мясным соусами, " +
						"а еще их подают с грибами, пармезаном или рагу.",
				R.drawable.pasta_20);
		insert(db, "PASTA", "Фузилли Букати",
				"Как понятно из названия, эта паста представляет собой " +
						"смесь из пасты фузилли и букатини. От фузилли " +
						"она получила свою характерную спиральную форму, " +
						"а от букатини — длину и полый центр. " +
						"Подходит практически ко всем видам соусов.",
				R.drawable.pasta_21);
		insert(db, "PASTA", "Лазаньетте",
				"Конечно, вы знаете лазанью — один из самых популярных видов " +
						"пасты во всем мире, но мало кто знает, что существует " +
						"более мелкая версия этого итальянского блюда под названием лазаньетте." +
						" Ее можно подавать в двух формах — положив один слой на" +
						" другой с различными ингредиентами между ними (как в " +
						"обычной лазанье) или просто выложить на тарелку с другими " +
						"ингредиентами.",
				R.drawable.pasta_22);
		insert(db, "PASTA", "Стриньоцци",
				"Переводится как «шнурки на ботинках». " +
						"Это длинная тонкая паста, похожая на спагетти, " +
						"типичная для итальянского региона Умбрия. Пасту" +
						" делают вручную и обычно подают с черными трюфелями, " +
						"мясным рагу, грибным или томатным соусом и т.д.",
				R.drawable.pasta_23);
		insert(db, "PASTA", "Ризони",
				"Также известная как ризи. Напоминает рис как " +
						"по форме, так и по размеру. " +
						"Из-за своего маленького размера " +
						"обычно подается в кружках, но также отлично " +
						"комбинируется с салатами и тушеными блюдами." +
						" Бывает самых разнообразных вкусов и цветов, например " +
						"со шпинатом, перцем и сушеными томатами.",
				R.drawable.pasta_24);
		insert(db, "PASTA", "Паккери",
				"Этот вид пасты родом из Кампании и Калабрии. " +
						"Паккери — очень крупные трубочки. " +
						"Обычно гладкие, но также есть рифленый " +
						"вариант под названием паккери миллериге. " +
						"Этот вид макаронных изделий можно подавать " +
						"с болоньезе и другими соусами или, благодаря их " +
						"крупному размеру, фаршировать сыром, морепродуктами " +
						"или мясом и запекать.",
				R.drawable.pasta_25);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		updateMyDB(db, oldV, newV);
	}
}
