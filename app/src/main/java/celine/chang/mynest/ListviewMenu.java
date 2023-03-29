package celine.chang.mynest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListviewMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_menu);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView listview = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter();

        //Adapter 안에 아이템 의 정보 담기
        adapter.addItem(new Item("1", "item1"));
        adapter.addItem(new Item("2", "item2"));
        adapter.addItem(new Item("3", "item3"));
        adapter.addItem(new Item("4", "item3"));

        //리스트 뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }

    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Item> items = new ArrayList<Item>();

        public void addItem(Item item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Item item = items.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // listitem layout을 inflate 해준다.(memory에 올려준다)
            convertView = inflater.inflate(R.layout.listview_menu, viewGroup, false);

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);

            tv_num.setText(item.getNum());
            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.getNum()+" "+item.getName()+" clicked!", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;  //뷰 객체 반환


        }
    }
}


