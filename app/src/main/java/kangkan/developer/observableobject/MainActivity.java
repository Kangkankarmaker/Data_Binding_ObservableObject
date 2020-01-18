package kangkan.developer.observableobject;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.PropertyChangeRegistry;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kangkan.developer.observableobject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);



        final student aStudent =new student("Kangkan Karmaker",22);
        binding.setAStudent(aStudent);


    }



    public class student implements Observable{
        private PropertyChangeRegistry register=new PropertyChangeRegistry();
        private String name;
        private int age;

        public student(String name, int age) {
            this.name=name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
            register.notifyChange(this,BR.name);
        }


        @Bindable
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
            register.add(callback);

        }

        @Override
        public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
            register.remove(callback);

        }
    }


}