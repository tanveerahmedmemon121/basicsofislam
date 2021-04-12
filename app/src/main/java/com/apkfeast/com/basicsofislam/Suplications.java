package com.apkfeast.com.basicsofislam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Suplications extends AppCompatActivity {

    public DuaAdapter adapter;
    AdView supad;
    private String title;
    private String dua1;
    private String trans1;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suplications);
        mRecyclerview = findViewById(R.id.recyclerview);
        supad = findViewById(R.id.supad);

        MobileAds.initialize(this, getString(R.string.APP_ID));
        supad.loadAd(new AdRequest.Builder().build());
        ArrayList<DuaItem> mDuaList = new ArrayList<DuaItem>();

        mDuaList.add(new DuaItem(getString(R.string.WhenWakingUp)));
        //1
        mDuaList.add(new DuaItem(getString(R.string.wearinggarment)));
        //2
        mDuaList.add(new DuaItem(getString(R.string.market)));
        //3
        mDuaList.add(new DuaItem(getString(R.string.someonewearnewgar)));
        //4
        mDuaList.add(new DuaItem(getString(R.string.beforeundress)));
        //5
        mDuaList.add(new DuaItem(getString(R.string.beforetoilet)));
        //6
        mDuaList.add(new DuaItem(getString(R.string.leavingtoilet)));
        //7
        mDuaList.add(new DuaItem(getString(R.string.startablution)));
        //8
        mDuaList.add(new DuaItem(getString(R.string.completeablution)));
        //9
        mDuaList.add(new DuaItem(getString(R.string.leavinghome)));
        //10
        mDuaList.add(new DuaItem(getString(R.string.enteringhome)));
        //11
        mDuaList.add(new DuaItem(getString(R.string.goingtomosque)));
        //12
        mDuaList.add(new DuaItem(getString(R.string.enteringmosque)));
        //13
        mDuaList.add(new DuaItem(getString(R.string.leavemosque)));
        //14
        mDuaList.add(new DuaItem(getString(R.string.azan)));
        //15
        mDuaList.add(new DuaItem(getString(R.string.aftertakbeer)));
        //16
        mDuaList.add(new DuaItem(getString(R.string.rukooa)));
        //17
        mDuaList.add(new DuaItem(getString(R.string.risingrukoo)));
        //18
        mDuaList.add(new DuaItem(getString(R.string.duringsujood)));
        //19
        mDuaList.add(new DuaItem(getString(R.string.betweensujood)));
        //20
        mDuaList.add(new DuaItem(getString(R.string.afterrecquran)));
        //21
        mDuaList.add(new DuaItem(getString(R.string.tashahhud)));
        //22
        mDuaList.add(new DuaItem(getString(R.string.aftertashahhud)));
        //23
        mDuaList.add(new DuaItem(getString(R.string.beforesalam)));
        //24
        mDuaList.add(new DuaItem(getString(R.string.aftersalam)));
        //25
        mDuaList.add(new DuaItem(getString(R.string.istikhara)));
        //26
        mDuaList.add(new DuaItem(getString(R.string.inmornandeve)));
        //27
        mDuaList.add(new DuaItem(getString(R.string.beforesleeping)));
        //28
        mDuaList.add(new DuaItem(getString(R.string.duringturningnight)));
        //29
        mDuaList.add(new DuaItem(getString(R.string.feelingunrestsleep)));
        //30
        mDuaList.add(new DuaItem(getString(R.string.upondream)));
        //31
        mDuaList.add(new DuaItem(getString(R.string.qunootalwitr)));
        //32
        mDuaList.add(new DuaItem(getString(R.string.aftersalamofwitr)));
        //33
        mDuaList.add(new DuaItem(getString(R.string.foranxiety)));
        //34
        mDuaList.add(new DuaItem(getString(R.string.oneindistress)));
        //35
        mDuaList.add(new DuaItem(getString(R.string.encounteringenemy)));
        //36
        mDuaList.add(new DuaItem(getString(R.string.doubtinfaith)));
        //37
        mDuaList.add(new DuaItem(getString(R.string.settleadebt)));
        //38
        mDuaList.add(new DuaItem(getString(R.string.whisperinginprayer)));
        //39
        mDuaList.add(new DuaItem(getString(R.string.affairsdifficult)));
        //40
        mDuaList.add(new DuaItem(getString(R.string.sin)));
        //41
        mDuaList.add(new DuaItem(getString(R.string.expelldevil)));
        //42
        mDuaList.add(new DuaItem(getString(R.string.mishap)));
        //43
        mDuaList.add(new DuaItem(getString(R.string.childrenprotec)));
        //44
        mDuaList.add(new DuaItem(getString(R.string.visitingsic)));
        //45
        mDuaList.add(new DuaItem(getString(R.string.sickexcel)));
        //46
        mDuaList.add(new DuaItem(getString(R.string.losthopeforlife)));
        //47
        mDuaList.add(new DuaItem(getString(R.string.instforoneneardeath)));
        //48
        mDuaList.add(new DuaItem(getString(R.string.affectedcalamity)));
        //49
        mDuaList.add(new DuaItem(getString(R.string.closingeyesofdeceased)));
        //50
        mDuaList.add(new DuaItem(getString(R.string.atfuneral)));

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Suplications.this);
        DuaAdapter mAdapter = new DuaAdapter(mDuaList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setBackgroundColor(1);

        mAdapter.SetOnItemClickListener(new DuaAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                switch (position) {
                    case 0:
                        title = getString(R.string.WhenWakingUp);
                        dua1 = getString(R.string.wakedua1);
                        trans1 = getString(R.string.tr1);
                        showDua();
                        break;
                    case 1:
                        title = getString(R.string.wearinggarment);
                        dua1 = getString(R.string.dc1);
                        trans1 = getString(R.string.tc1);
                        showDua();
                        break;
                    case 2:
                        title = (getString(R.string.market));
                        dua1 = getString(R.string.tc2);
                        trans1 = getString(R.string.trcase2);
                        showDua();
                        break;
                    case 3:
                        title = getString(R.string.someonewearnewgar);
                        dua1 = getString(R.string.dc3);
                        trans1 = getString(R.string.tc3);
                        showDua();
                        break;
                    case 4:
                        title = getString(R.string.beforeundress);
                        dua1 = getString(R.string.dc4);
                        trans1 = getString(R.string.tc4);
                        showDua();
                        break;
                    case 5:
                        title = getString(R.string.beforetoilet);
                        dua1 = getString(R.string.dc5);
                        trans1 = getString(R.string.tc5);
                        showDua();
                        break;
                    case 6:
                        title = getString(R.string.leavingtoilet);
                        dua1 = getString(R.string.dc6);
                        trans1 = getString(R.string.tc6);
                        showDua();
                        break;
                    case 7:
                        title = getString(R.string.startablution);
                        dua1 = getString(R.string.tc7);
                        trans1 = getString(R.string.tc7ac);
                        showDua();
                        break;
                    case 8:
                        title = getString(R.string.completeablution);
                        dua1 = getString(R.string.dc8);
                        trans1 = getString(R.string.tc8);
                        showDua();
                        break;
                    case 9:
                        title = getString(R.string.leavinghome);
                        dua1 = getString(R.string.dc9);
                        trans1 = getString(R.string.tc9);
                        showDua();
                        break;
                    case 10:
                        title = getString(R.string.enteringhome);
                        dua1 = getString(R.string.dc10);
                        trans1 = getString(R.string.tc10);
                        showDua();
                        break;
                    case 11:
                        title = getString(R.string.goingtomosque);
                        dua1 = getString(R.string.dc11);
                        trans1 = getString(R.string.tc11);
                        showDua();
                        break;
                    case 12:
                        title = getString(R.string.enteringmosque);
                        dua1 = getString(R.string.dc12);
                        trans1 = getString(R.string.tc12);
                        showDua();
                        break;
                    case 13:
                        title = getString(R.string.leavemosque);
                        dua1 = getString(R.string.dc13);
                        trans1 = getString(R.string.tc13);
                        showDua();
                        break;
                    case 14:
                        title = getString(R.string.azan);
                        dua1 = getString(R.string.dc14);
                        trans1 = getString(R.string.tc14);
                        showDua();
                        break;
                    case 15:
                        title = getString(R.string.aftertakbeer);
                        dua1 = getString(R.string.dc15);
                        trans1 = getString(R.string.tc15);
                        showDua();
                        break;
                    case 16:
                        title = getString(R.string.rukooa);
                        dua1 = getString(R.string.dc16);
                        trans1 = getString(R.string.tc16);
                        showDua();
                        break;
                    case 17:
                        title = getString(R.string.risingrukoo);
                        dua1 = getString(R.string.dc17);
                        trans1 = getString(R.string.tc17);
                        showDua();
                        break;
                    case 18:
                        title = getString(R.string.duringsujood);
                        dua1 = getString(R.string.dc18);
                        trans1 = getString(R.string.tc18);
                        showDua();
                        break;
                    case 19:
                        title = getString(R.string.betweensujood);
                        dua1 = getString(R.string.dc19);
                        trans1 = getString(R.string.tc19);
                        showDua();
                        break;
                    case 20:
                        title = getString(R.string.afterrecquran);
                        dua1 = getString(R.string.dc20);
                        trans1 = getString(R.string.tc20);
                        showDua();
                        break;
                    case 21:
                        title = getString(R.string.tashahhud);
                        dua1 = getString(R.string.dc21);
                        trans1 = getString(R.string.tc21);
                        showDua();
                        break;
                    case 22:
                        title = getString(R.string.aftertashahhud);
                        dua1 = getString(R.string.dc22);
                        trans1 = getString(R.string.tc22);
                        showDua();
                        break;
                    case 23:
                        title = getString(R.string.beforesalam);
                        dua1 = getString(R.string.dc23);
                        trans1 = getString(R.string.tc23);
                        showDua();
                        break;
                    case 24:
                        title = getString(R.string.aftersalam);
                        dua1 = getString(R.string.dc24);
                        trans1 = getString(R.string.tc24);
                        showDua();
                        break;
                    case 25:
                        title = getString(R.string.istikhara);
                        dua1 = getString(R.string.dc25);
                        trans1 = getString(R.string.tc25);
                        showDua();
                        break;
                    case 26:
                        title = getString(R.string.inmornandeve);
                        dua1 = getString(R.string.dc26);
                        trans1 = getString(R.string.tc26);
                        showDua();
                        break;
                    case 27:
                        title = getString(R.string.beforesleeping);
                        dua1 = getString(R.string.dc27);
                        trans1 = getString(R.string.tc27);
                        showDua();
                        break;
                    case 28:
                        title = getString(R.string.duringturningnight);
                        dua1 = getString(R.string.dc28);
                        trans1 = getString(R.string.tc28);
                        showDua();
                        break;
                    case 29:
                        title = getString(R.string.feelingunrestsleep);
                        dua1 = getString(R.string.dc29);
                        trans1 = getString(R.string.tc29);
                        showDua();
                        break;
                    case 30:
                        title = getString(R.string.upondream);
                        dua1 = getString(R.string.dc30);
                        trans1 = getString(R.string.tc30);
                        showDua();
                        break;
                    case 31:
                        title = getString(R.string.qunootalwitr);
                        dua1 = getString(R.string.dc31);
                        trans1 = getString(R.string.tc31);
                        showDua();
                        break;
                    case 32:
                        title = getString(R.string.aftersalamofwitr);
                        dua1 = getString(R.string.dc32);
                        trans1 = getString(R.string.tc32);
                        showDua();
                        break;
                    case 33:
                        title = getString(R.string.foranxiety);
                        dua1 = getString(R.string.dc33);
                        trans1 = getString(R.string.tc33);
                        showDua();
                        break;
                    case 34:
                        title = getString(R.string.oneindistress);
                        dua1 = getString(R.string.dc34);
                        trans1 = getString(R.string.tc34);
                        showDua();
                        break;
                    case 35:
                        title = getString(R.string.encounteringenemy);
                        dua1 = getString(R.string.dc35);
                        trans1 = getString(R.string.tc35);
                        showDua();
                        break;
                    case 36:
                        title = getString(R.string.doubtinfaith);
                        dua1 = getString(R.string.dc36);
                        trans1 = getString(R.string.tc36);
                        showDua();
                        break;
                    case 37:
                        title = getString(R.string.settleadebt);
                        dua1 = getString(R.string.dc37);
                        trans1 = getString(R.string.tc37);
                        showDua();
                        break;
                    case 38:
                        title = getString(R.string.whisperinginprayer);
                        dua1 = getString(R.string.dc38);
                        trans1 = getString(R.string.tc38);
                        showDua();
                        break;
                    case 39:
                        title = getString(R.string.affairsdifficult);
                        dua1 = getString(R.string.dc39);
                        trans1 = getString(R.string.tc39);
                        showDua();
                        break;
                    case 40:
                        title = getString(R.string.sin);
                        dua1 = getString(R.string.dc40);
                        trans1 = getString(R.string.tc40);
                        showDua();
                        break;
                    case 41:
                        title = getString(R.string.expelldevil);
                        dua1 = getString(R.string.dc41);
                        trans1 = getString(R.string.tc41);
                        showDua();
                        break;
                    case 42:
                        title = getString(R.string.mishap);
                        dua1 = getString(R.string.dc42);
                        trans1 = getString(R.string.tc42);
                        showDua();
                        break;
                    case 43:
                        title = getString(R.string.childrenprotec);
                        dua1 = getString(R.string.dc43);
                        trans1 = getString(R.string.tc43);
                        showDua();
                        break;
                    case 44:
                        title = getString(R.string.visitingsic);
                        dua1 = getString(R.string.dc44);
                        trans1 = getString(R.string.tc44);
                        showDua();
                        break;
                    case 45:
                        title = getString(R.string.sickexcel);
                        dua1 = getString(R.string.dc45);
                        trans1 = getString(R.string.tc45);
                        showDua();
                        break;
                    case 46:
                        title = getString(R.string.losthopeforlife);
                        dua1 = getString(R.string.dc46);
                        trans1 = getString(R.string.tc46);
                        showDua();
                        break;
                    case 47:
                        title = getString(R.string.instforoneneardeath);
                        dua1 = getString(R.string.dc47);
                        trans1 = getString(R.string.tc47);
                        showDua();
                        break;
                    case 48:
                        title = getString(R.string.affectedcalamity);
                        dua1 = getString(R.string.dc48);
                        trans1 = getString(R.string.tc48);
                        showDua();
                        break;
                    case 49:
                        title = getString(R.string.closingeyesofdeceased);
                        dua1 = getString(R.string.dc49);
                        trans1 = getString(R.string.tc49);
                        showDua();
                        break;
                    case 50:
                        title = getString(R.string.atfuneral);
                        dua1 = getString(R.string.dc50);
                        trans1 = getString(R.string.tc50);
                        showDua();
                        break;

                }


            }
        });


    }

    private void showDua() {

        Intent intent = new Intent(Suplications.this, DuaShow.class);
        intent.putExtra("title", title);
        intent.putExtra("dua1", dua1);
        intent.putExtra("trans1", trans1);
        startActivity(intent);
    }
}
//        //51
//        mDuaList.add(new DuaItem(getString(R.string.rewardmorefuneral)));
//        //52
//        mDuaList.add(new DuaItem(getString(R.string.condolence)));
//        //53
//        mDuaList.add(new DuaItem(getString(R.string.placingdeceasedingrave)));
//        //54
//        mDuaList.add(new DuaItem(getString(R.string.afterburryingdeceased)));
//        //55
//        mDuaList.add(new DuaItem(getString(R.string.visitgrave)));
//        //56
//        mDuaList.add(new DuaItem(getString(R.string.windstorm)));
//        //57
//        mDuaList.add(new DuaItem(getString(R.string.hearthunder)));
//        //58
//        mDuaList.add(new DuaItem(getString(R.string.forrain)));
//        //59
//        mDuaList.add(new DuaItem(getString(R.string.whenitrains)));
//        //60
//        mDuaList.add(new DuaItem(getString(R.string.afterrainfall)));
//        //61
//        mDuaList.add(new DuaItem(getString(R.string.clearskies)));
//        //62
//        mDuaList.add(new DuaItem(getString(R.string.cresentmoon)));
//        //63
//        mDuaList.add(new DuaItem(getString(R.string.uponbreakfast)));
//        //64
//        mDuaList.add(new DuaItem(getString(R.string.beforeeating)));
//        //65
//        mDuaList.add(new DuaItem(getString(R.string.uponcompletemeal)));
//        //66
//        mDuaList.add(new DuaItem(getString(R.string.duaguestforhost)));
//        //67
//        mDuaList.add(new DuaItem(getString(R.string.uponsneezing)));
//        //68
//        mDuaList.add(new DuaItem(getString(R.string.newlywed)));
//        //69
//        mDuaList.add(new DuaItem(getString(R.string.beforesex)));
//        //70
//        mDuaList.add(new DuaItem(getString(R.string.anger)));
//        //71
//        mDuaList.add(new DuaItem(getString(R.string.gathering)));
//        //72
//        mDuaList.add(new DuaItem(getString(R.string.concludegather)));
//        //73
//        mDuaList.add(new DuaItem(getString(R.string.protectionfromdajjal)));
//        //74
//        mDuaList.add(new DuaItem(getString(R.string.fearofshirk)));
//        //75
//        mDuaList.add(new DuaItem(getString(R.string.fortravel)));
//        //76
//        mDuaList.add(new DuaItem(getString(R.string.whilereturntravel)));
//        //78
