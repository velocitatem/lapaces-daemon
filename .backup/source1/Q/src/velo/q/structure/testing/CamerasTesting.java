package velo.q.structure.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.q.structure.data.Cameras;

class CamerasTesting {

	@Test
	void test() {
		ArrayList<String> cameras = (ArrayList<String>) Cameras.getCamerasFor().fetch(new Object[] {"Berlin"});
		for(String cam : cameras) {
			System.out.println(cam);
		}
		System.out.println();
	}

}
