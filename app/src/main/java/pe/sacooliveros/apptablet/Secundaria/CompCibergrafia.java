package pe.sacooliveros.apptablet.Secundaria;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import pe.sacooliveros.apptablet.Json.Api;
import pe.sacooliveros.apptablet.Json.LinksListas;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.ViewWebUrlFrag;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompCibergrafia extends Fragment {

    View  rootview;

    ListView listView;

    ProgressBar progresurls;

  public CompCibergrafia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview= inflater.inflate(R.layout.fragment_educacion_fisica, container, false);

        listView= rootview.findViewById(R.id.list_jsonfisicaurl);

        progresurls=rootview.findViewById(R.id.progresurls);


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api  api= retrofit.create(Api.class);
        Call<List<LinksListas>> call= api.getUrlsphotos();

        call.enqueue(new Callback<List<LinksListas>>() {
            @Override
            public void onResponse(Call<List<LinksListas>> call, Response<List<LinksListas>> response) {
                List<LinksListas> linksListas= response.body();

//                  for (LinksListas h:linksListas)
//                {
//                    Log.d("userId", String.valueOf(h.getAlbumID()));
//                    Log.d("id", String.valueOf(h.getId()));
//                    Log.d("title",h.getTitle());
//                    Log.d("body", h.getUrl());
//                }




                String [] listaurls= new String[linksListas.size()];

                for( int i=0; i<linksListas.size();i++)
                {
                   listaurls[i]=linksListas.get(i).getUrl();
                }

                listView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, listaurls));

                progresurls.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<LinksListas>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progresurls.setVisibility(View.GONE);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String textItemList = (String) listView.getItemAtPosition(position);

                Toast.makeText(getContext(), position + textItemList ,Toast.LENGTH_SHORT).show();


                Fragment fragment2 = new ViewWebUrlFrag();
                FragmentManager fmanager = getActivity().getSupportFragmentManager();
                if (fmanager != null) {

                    Bundle args = new Bundle();
                    args.putString( "UrlDescription",textItemList);

                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }

                }


            }
        });





        return rootview;
    }

}
