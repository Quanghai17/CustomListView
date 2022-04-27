package com.example.bktra_02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSinhVien;
    ArrayList<SinhVien> SinhVienList = new ArrayList<>();
    ArrayAdapter<SinhVien> adapter;
    Button btnThem, btnSua, btnReset;
    EditText edtName, edtLop;
    RadioGroup rdoGroup;
    RadioButton rdoNam, rdoNu;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        adapter = new ArrayAdapter<SinhVien>(this, 0, SinhVienList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.sinhvien_item,null);

                TextView txtName = convertView.findViewById(R.id.txtName);
                TextView txtLop = convertView.findViewById(R.id.txtLop);
                TextView txtGioiTinh = convertView.findViewById(R.id.txtGioiTinh);

                SinhVien sv = SinhVienList.get(position);

                txtName.setText(sv.getName());
                txtLop.setText(sv.getLop());
                txtGioiTinh.setText(sv.getGioitinh());
                return convertView;
            }
        };

        lvSinhVien.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setName(edtName.getText().toString());
                sv.setLop(edtLop.getText().toString());
                sv.setGioitinh(rdoNam.getText().toString());


            SinhVienList.add(sv);
            adapter.notifyDataSetChanged();
            edtName.setText(null);
            edtLop.setText(null);
            }
        });

        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtName.setText(SinhVienList.get(i).getName());
                edtLop.setText(SinhVienList.get(i).getLop());
                rdoNam.setText(SinhVienList.get(i).getGioitinh());
                vitri = i;
            }
        });



        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setName(edtName.getText().toString());
                sv.setLop((edtLop.getText().toString()));
                sv.setGioitinh((rdoNam.getText().toString()));
                SinhVienList.set(vitri , sv);
                adapter.notifyDataSetChanged();
                edtName.setText(null);
                edtLop.setText(null);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText(null);
                edtLop.setText(null);
                rdoNam.setChecked(true);
            }
        });

//        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                SinhVienList.remove(i);
//                adapter.notifyDataSetChanged();
//                return ;
//            }
//        });
    }

    private void anhxa() {
        lvSinhVien = findViewById(R.id.lvSinhVien);
        edtName = findViewById(R.id.edtName);
        edtLop = findViewById(R.id.edtLop);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        btnReset = findViewById(R.id.btnReset);
    }
}