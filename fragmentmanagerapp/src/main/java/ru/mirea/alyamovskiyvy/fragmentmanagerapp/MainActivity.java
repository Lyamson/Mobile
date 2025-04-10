package ru.mirea.alyamovskiyvy.fragmentmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ShareViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ShareViewModel.class);
        HashMap<String, String> countiesInfo = new HashMap() {{
            put("Австрия", "Название страны происходит от др.-в.-нем. Ostarrichi (позже — Osterreich) — «восточная страна» (ostar — «восток», richi — «страна»)[10]. Название «Австрия» впервые упоминается в документе от 1 ноября 996 года.\n" +
                    "\n" +
                    "Австрийский флаг является одним из самых древних государственных символов в мире. Согласно преданию, в 1191 году, во время одной из битв третьего крестового похода, белоснежная рубашка Леопольда V полностью была забрызгана кровью. Когда герцог снял с себя широкий пояс, на рубашке образовалась белая полоса. Сочетание этих цветов стало его знаменем, а в будущем флагом Австрийской Республики.\n");
            put("Аргентина", "Название страны «Аргентина», является производным от латинского слова лат. argentum (серебро), которое в свою очередь происходит от греческого ἀργήντος (аргентос), более раннее ἀργήεις, что означало белый, сияющий[9]. Αργεντινός (аргентинос) — греческое прилагательное, означавшее серебристый[10]. Название возникло после того, как Себастьян Кабот подобрал оставленного экспедицией Хуана Диаса де Солиса на берегу Франциско дель Пуэрто, который поведал Каботу о «Белом короле» и Серебряных горах[исп.], расположенных к северу от Ла-Платы. Кабот поверил легенде и, оставив первоначальный план по исследованию навигации на пути к Молуккским островам, найденным экспедицией Магеллана-Элькано, отправился на поиски серебра[11]. Но информация оказалась ложной — в бассейне Ла-Платы отсутствуют залежи ценных металлов, скорее, в легенде говорилось про империю инков, но слух о серебре стал причиной, по которой страна была названа Аргентиной[12].");
            put("Бразилия", "Территории Нового Света, присоединённые к Португалии мореплавателем Педру Алваришем Кабралом, были названы им Землёй Истинного Креста (порт. Terra de Vera Cruz), затем эти территории стали называться Землёй Святого Креста (порт. Terra de Santa Cruz). Однако немного позднее за этой страной закрепилось другое название — Terra do Brasil (в русском написании — Бразилия).");
            put("Греция", "Слово «Греция» имеет латинское происхождение и в греческом языке сегодня не используется.\n" +
                    "\n" +
                    "Самоназвание греками своей страны — Элла́да (Эллас, греч. Ελλάδα)[17]. Изначально, согласно «Илиаде» Гомера, Эллада — название области в южной Фессалии — Фтиотиды; постепенно оно распространилось на всю Грецию[18]. С принятием термина эллин общим для обозначения всех греков, «Эллада» стало собирательным именем для всей материковой Греции, а затем — и всей Греции, включая архипелаги, острова и области в Малой Азии (в противоположность исторической Великой Греции, расположенной в Южной Италии)[19].");
            put("Дания", "Этимология топонима «Дания» (Danmark) в настоящее время точно не выяснена и остаётся предметом научных споров; в источниках V—VI вв. упоминается древнегерманское племя даны, жившее на Ютландском п-ове. В IX в. при административном устройстве пограничных земель империи Карла Великого была образована Danmark — «датская марка» (марка — др.-верх.-нем. «граница, пограничные земли»), ставшая в XI в. государством Danmark[14].");
            put("Испания", "В течение столетий возникало множество гипотез по поводу этимологии названия «Испания». Считается, что оно происходит от римского топонима Hispania, происхождение которого остаётся не до конца выясненным, хотя документально подтверждено, что финикийцы и карфагеняне именовали регион Spania, поэтому наиболее распространённой версией этимологии является семитско-финикийская[11][12].");
            put("Италия", "Происхождение слова Italia точно неизвестно. Согласно наиболее распространённой точке зрения, термин пришёл из Греции и означает «страна телят»[11][12][13]. Бык был символом народов, населявших юг Италии, и часто изображался бодающим римскую Волчицу. Изначально название Italia применялось только к той части территории, которую теперь занимает Южная Италия (современная провинция Калабрия).");
            put("Канада", "Название Канада происходит от слова kanata, означающего «поселение», «деревня» и «земля», «край»[6][7] на языке лаврентийских ирокезов, которые зимовали в деревне Стадакона (в окрестностях современного Квебека), — первых индейцев, которых Жак Картье встретил на Гаспе летом 1534 года в их летнем лагере (ср. с минго kanötayë’ «деревня, город»[8] и ононд. ganatáje «город»[9] из других ирокезских языков). В 1535 году жители местности, где ныне располагается город Квебек, использовали это слово, чтобы направить его в деревню Стадакона[10]. Вскоре после экспедиции Картье лаврентийское племя бесследно исчезло. По поводу причин этого существует несколько гипотез, включая завезённые европейцами болезни и завоевание гуронами или Конфедерацией ирокезов, но ни одна из них не подтверждена достоверно[11].");
        }};

        for (String country :
                countiesInfo.keySet()) {
            viewModel.addCountryWithInfo(country, countiesInfo.get(country));
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.countriesContainerView, ItemFragment.class, null)
                    .add(R.id.infoContainerView, InfoFragment.class, null)
                    .commit();
        }
    }
}