package com.example.jym.fun;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Machenike-Pc on 2016/4/14.
 */
public class Tab2 extends Fragment{
    private TabLayout mtablayout;
    private  View view1,view2,view3;
    private List<String> titlelist=new ArrayList<>();
    private ArrayList<View> viewlist=new ArrayList<>();
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_2,container,false);
        //View view_sz=inflater.inflate(R.layout.tab2_sz,container,false);

        mtablayout= (TabLayout) view.findViewById(R.id.tabs);
        //添加标题
        titlelist.add("神作");
        titlelist.add("新番");
        titlelist.add("推荐");
        //添加选项卡和标题
        mtablayout.setTabMode(TabLayout.MODE_FIXED);
        mtablayout.addTab(mtablayout.newTab().setText(titlelist.get(0)));
        mtablayout.addTab(mtablayout.newTab().setText(titlelist.get(1)));
        mtablayout.addTab(mtablayout.newTab().setText(titlelist.get(2)));


        //为Viewlist添加View
        view1=LayoutInflater.from(getActivity()).inflate(R.layout.tab2_sz,null);
        view2=LayoutInflater.from(getActivity()).inflate(R.layout.tab2_xf,null);
        view3=LayoutInflater.from(getActivity()).inflate(R.layout.tab2_tj,null);
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);
        //添加适配器
        viewPager= (ViewPager)view.findViewById(R.id.vp_view);
        Mypageradapter mypageradapter=new Mypageradapter(viewlist);
        viewPager.setAdapter(mypageradapter);
        mtablayout.setupWithViewPager(viewPager);


        //为view1中的listview填充内容
        ListView listview_sz= (ListView) view1.findViewById(R.id.list_sz);//!!!!注意这里的view1万不要直接用view！部件需要在所在布局下面查找。
        String[] sz={"新世纪福音战士","Clannad","叛逆的鲁路修","海贼王","钢之炼金术师fa","命运石之门","龙与虎",
                "未闻花名","进击的巨人","死亡笔记","fate zero","寒蝉鸣泣之时","化物语","凉宫春日的忧郁","银魂",
                "Angel beats","魔法少女小圆","全金属狂潮","夏目友人帐","待续..."};
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(getActivity(),R.layout.list_item_sz,sz);
        listview_sz.setAdapter(adapter1);

        return view;
    }

    //为viewpager定义适配器类
    class Mypageradapter extends PagerAdapter{
        private List<View> mViewList=new ArrayList<>();
        public  Mypageradapter(List<View> viewlist){
            mViewList=viewlist;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);//页卡标题
        }

    }


}
