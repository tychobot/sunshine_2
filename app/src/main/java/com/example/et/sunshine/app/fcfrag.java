//package com.example.et.sunshine.app;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * Created by et on 15-2-2015.
// * Dit is mijn code, maar ik ga verder met die van de cursus
// */
////public class ForecastFragment {
////}
//
// //
//public class ForecastFragment extends Fragment {
//    public ArrayAdapter<String> mForecastAdapter;
//    public ForecastFragment() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//
//
//        ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList("Today - Sunny - 20/15",
//                "Tomorrow - Sunny - 20/15", "Saturday - Sunny - 20/15",
//                "Sunday - Sunny - 20/15", "Monday - Sunny - 20/15",
//                "Tuesday - Sunny - 20/15"));
//
//// an arrayadapter will take data from a source and uses it to populate a listview it's attached to
//        ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
//                //the current context: this fragment's parent activity
//                getActivity(),
//                // een layout file om het uit te halen
//                R.layout.list_item_forecast,
//                // iets  uit het layout file om het in te douwen? id of the textview to populate
//                R.id.list_item_forecast_textview,
//                // datasource
//                weekForecast);
//
//
//        ListView lv_id = (ListView) rootView.findViewById(R.id.listview_forecast);
//        lv_id.setAdapter(mForecastAdapter);
//
//
//
//
//
//        return rootView;
//    }  // oncreateview method
//
//    public class FetchWeatherTask extends AsyncTask <String, Void, String>{
//        public FetchWeatherTask() {
//        } // constructor
//
//        @Override
//        protected String doInBackground(String... params) {
//            // return null;
//            //}
//
//            HttpURLConnection urlConnection = null;
//            BufferedReader reader = null;
//
//            // Will contain the raw JSON response as a string.
//            String forecastJsonStr = null;
//            try {
//
//                // Construct the URL for the OpenWeatherMap query
//
//                // Possible parameters are available at OWM's forecast API page, at
//
//                // http://openweathermap.org/API#forecast
//
//                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");
//                // Create the request to OpenWeatherMap, and open the connection
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("GET");
//                urlConnection.connect();
//
//                // Read the input stream into a String
//                InputStream inputStream = urlConnection.getInputStream();
//                StringBuffer buffer = new StringBuffer();
//                if (inputStream == null) {
//                    // Nothing to do.
//                    forecastJsonStr = null;
//                }
//                reader = new BufferedReader(new InputStreamReader(inputStream));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
//                    // But it does make debugging a *lot* easier if you print out the completed
//                    // buffer for debugging.
//
//                    buffer.append(line + "\n");
//                }
//
//                if (buffer.length() == 0) {
//                    // Stream was empty.  No point in parsing.
//                    forecastJsonStr = null;
//                }
//                forecastJsonStr = buffer.toString();
//            } catch (IOException e) {
//                Log.e("PlaceholderFragment", "Error ", e);
//                // If the code didn't successfully get the weather data, there's no point in attempting
//                // to parse it.
//                forecastJsonStr = null;
//            } finally {
//                if (urlConnection != null) {
//                    urlConnection.disconnect();
//                }
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (final IOException e) {
//                        Log.e("PlaceholderFragment", "Error closing stream", e);
//                    }  // catch
//                }  // if
//            } // finally
//            return forecastJsonStr;
//        } // class fetchweathertask
//    }
//} // Forecastfragment class