package velo.ladealpha.ai.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.nd4j.linalg.dataset.DataSet;

import velo.ladealpha.ai.dl4j.DeepModelData;

class DataSetTesting {

	@Test
	void test() {
		DeepModelData deepModelData;
		try {
			deepModelData = new DeepModelData("/home/velo/Documents/Data/iris.data");
			deepModelData.build(4, 3, 150);
			deepModelData.separate(0.65);
			deepModelData.normalize();
			
			DataSet d0 = deepModelData.getTrainingData();
			System.out.println(d0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
