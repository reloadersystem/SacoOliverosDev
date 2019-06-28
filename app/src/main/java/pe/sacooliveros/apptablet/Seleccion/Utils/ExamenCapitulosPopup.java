package pe.sacooliveros.apptablet.Seleccion.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import pe.sacooliveros.apptablet.R;

public class ExamenCapitulosPopup extends FragmentManager {

    public Context dataContext;

    public void customDialog(Context context) {
        dataContext = context;

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popupcapitulos, null);

        CardView crd_capitulos1;
        CardView crd_capitulos2;
        CardView crd_capitulos3;


        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        crd_capitulos1 = view2.findViewById(R.id.crd_capitulos_1);
        crd_capitulos2 = view2.findViewById(R.id.crd_capitulos_2);
        crd_capitulos3 = view2.findViewById(R.id.crd_capitulos_3);


        crd_capitulos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //CapitulosAdmisionfragment


            }
        });

        builder.setView(view2);
        alertDialog = builder.create();

        alertDialog.show();

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public FragmentTransaction beginTransaction() {
        return null;
    }

    @Override
    public boolean executePendingTransactions() {
        return false;
    }

    @Override
    public Fragment findFragmentById(int id) {
        return null;
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        return null;
    }

    @Override
    public void popBackStack() {

    }

    @Override
    public boolean popBackStackImmediate() {
        return false;
    }

    @Override
    public void popBackStack(String name, int flags) {

    }

    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        return false;
    }

    @Override
    public void popBackStack(int id, int flags) {

    }

    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        return false;
    }

    @Override
    public int getBackStackEntryCount() {
        return 0;
    }

    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        return null;
    }

    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {

    }

    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {

    }

    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {

    }

    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        return null;
    }

    @Override
    public List<Fragment> getFragments() {
        return null;
    }

    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment f) {
        return null;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks cb, boolean recursive) {

    }

    @Override
    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks cb) {

    }

    @Override
    public Fragment getPrimaryNavigationFragment() {
        return null;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }

    @Override
    public boolean isStateSaved() {
        return false;
    }
}
