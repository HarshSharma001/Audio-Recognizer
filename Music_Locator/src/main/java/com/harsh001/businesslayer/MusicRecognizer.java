package com.harsh001.businesslayer;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.harsh001.MusicLocatorApplication;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.File;

@Component
public class MusicRecognizer {
	private Music music;

	public Music getMusicDetails(String filepath) {
		//System.out.println(filepath);
		try {
			final MediaType MEDIA_TYPE_MP3 = MediaType.get("audio/mpeg; charset=utf-8");
			File file = new File(filepath);

			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			builder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
					.writeTimeout(5, TimeUnit.MINUTES) // write timeout
					.readTimeout(5, TimeUnit.MINUTES); // read timeout

			OkHttpClient client = builder.build();
			RequestBody data = new MultipartBody.Builder().setType(MultipartBody.FORM)
					.addFormDataPart("file", file.getName(), RequestBody.Companion.create(file, MEDIA_TYPE_MP3))
					.addFormDataPart("return", "apple_music,spotify")
					.addFormDataPart("enter your token here", "test").build();

			Request request = new Request.Builder().url("https://api.audd.io").post(data).build();
			Response response = null;
			response = client.newCall(request).execute();
			String result = null;
			result = response.body().string();

			MusicDetailsExtractor mde = MusicLocatorApplication.getMde();
			mde.extractMusicDetails(result);
			music = mde.getMusicInstance();

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return music;
	}
}
