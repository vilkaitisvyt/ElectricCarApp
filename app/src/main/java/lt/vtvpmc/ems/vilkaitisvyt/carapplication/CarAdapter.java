package lt.vtvpmc.ems.vilkaitisvyt.carapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CarAdapter extends BaseAdapter {

    private List<Car> cars = new ArrayList<>();
    private Context context;

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cars.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.car_item, null);

//        ImageView imageView = convertView.findViewById(R.id.carImageView);
//        TextView textViewTitle = convertView.findViewById(R.id.text_view_title);
//        TextView textViewDescription = convertView.findViewById(R.id.text_view_description);
//        TextView textViewDescription2 = convertView.findViewById(R.id.text_view_description2);
        TextView textViewDescription2 = convertView.findViewById(R.id.text_view_title);
        textViewDescription2.setText("" +
                "aaaaaaaaaaa");
//        imageView.setImageURI(Uri.parse(cars.get(position).getModel().getPhotoUrl()));
//        textViewTitle.setText(cars.get(position).getModel().getTitle());
//        textViewTitle.setText("test");
//        textViewDescription.setText("Plate number: " + cars.get(position).getPlateNumber());
//        textViewDescription2.setText("Battery left for : " + cars.get(position).getBatteryEstimatedDistance());

        return convertView;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Car> getCars() {
        return cars;
    }
}
