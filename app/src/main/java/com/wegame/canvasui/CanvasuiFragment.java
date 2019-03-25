package com.wegame.canvasui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tencent.component.R;

import org.json.JSONException;
import org.json.JSONObject;

public class CanvasuiFragment extends Fragment {

    public static final String uiJson = "{\n" +
            "  \"Area\": \"com.qzone.canvasui.widget.LinearAreaLayout\",\n" +
            "  \"shell\": {\n" +
            "    \"id\":\"left_thumb_root\",\n" +
            "    \"width\": \"match_parent\",\n" +
            "    \"height\": \"wrap_content\",\n" +
            "    \"orientation\": \"horizontal\"\n" +
            "  },\n" +
            "  \"children\": [\n" +
            "    {\n" +
            "      \"Area\": \"com.qzone.canvasui.widget.TagImageArea\",\n" +
            "      \"shell\": {\n" +
            "        \"id\":\"left_thumb_image\",\n" +
            "        \"width\": \"80 dp\",\n" +
            "        \"height\": \"80 dp\"\n" +
            "      }\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "      \"Area\": \"com.qzone.canvasui.widget.LinearAreaLayout\",\n" +
            "      \"shell\": {\n" +
            "        \"width\": \"match_parent\",\n" +
            "        \"height\": \"80 dp\",\n" +
            "        \"orientation\": \"vertical\",\n" +
            "        \"padding\":\"10 dp,0,10 dp,0\",\n" +
            "        \"gravity\":\"center_vertical\",\n" +
            "        \"bg_color\": \"#FFF8F8F8\"\n" +
            "      },\n" +
            "      \"children\": [\n" +
            "        {\n" +
            "          \"Area\": \"com.qzone.canvasui.widget.RichCanvasTextArea\",\n" +
            "          \"shell\": {\n" +
            "            \"id\":\"left_thumb_title\",\n" +
            "            \"width\": \"match_parent\",\n" +
            "            \"height\": \"wrap_content\",\n" +
            "            \"text\": \"这是标题\",\n" +
            "            \"text_color\": \"#ff000000\",\n" +
            "            \"text_size\": 14,\n" +
            "            \"max_line\":2\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"Area\": \"com.qzone.canvasui.widget.RichCanvasTextArea\",\n" +
            "          \"shell\": {\n" +
            "            \"id\":\"left_thumb_content\",\n" +
            "            \"width\": \"match_parent\",\n" +
            "            \"height\": \"wrap_content\",\n" +
            "            \"text\": \"这是内容\",\n" +
            "            \"text_color\": \"#ff777777\",\n" +
            "            \"text_size\": 14,\n" +
            "            \"max_line\":2\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvasui, container, false);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(uiJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonObject != null) {
            Log.e("datata", jsonObject.optString("Area"));
        }
        return view;

    }
}
