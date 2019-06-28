package pe.sacooliveros.apptablet.Noticias;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.sacooliveros.apptablet.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class noticiasFragment extends Fragment {

    View  rootview;

    private static  final String TAG= "NOTICIAS";

    private final static String API_KEY="84021f6725ccd7b9f876727e5604a43c";


    public noticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_noticias, container, false);

        final RecyclerView recyclerView= rootview.findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiInterface apiService= ApiClient.getClient().create(ApiInterface.class);


        Call<MoviesResponse> call= apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode =response.code();
                List<Movie> movies= response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getContext()));

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

                Log.e(TAG, t.toString());


            }
        });

        return rootview;
    }

}
