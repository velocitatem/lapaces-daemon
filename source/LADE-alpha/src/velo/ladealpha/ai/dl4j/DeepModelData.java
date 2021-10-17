package velo.ladealpha.ai.dl4j;

import java.io.File;
import java.io.IOException;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;

public class DeepModelData{
	private RecordReader recordReader;
	private DataSet datasetFULL, trainingData, testData;
	public DeepModelData(String path) throws Exception {
		int numLinesToSkip = 0;
        char delimiter = ',';
        recordReader = new CSVRecordReader(numLinesToSkip,delimiter);
        try {
        	File file = new File(path);        	
			recordReader.initialize(new FileSplit(file));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			throw e;
		}
        System.out.println(recordReader.getConf());
	}
	public void build(int inputSizePerRow, int classes, int size) {
		DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader, size, inputSizePerRow, classes);
		System.out.println(iterator);
		try {
			datasetFULL = iterator.next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void separate(double trainingSize) {
        SplitTestAndTrain testAndTrain = datasetFULL.splitTestAndTrain(trainingSize);        
        trainingData = testAndTrain.getTrain();
        testData = testAndTrain.getTest();
        
	}
	public void normalize() {
		DataNormalization normalizer = new NormalizerStandardize();
		normalizer.fit(trainingData);
		normalizer.transform(trainingData);
		normalizer.transform(testData);		
	}
	/**
	 * @return the trainingData
	 */
	public DataSet getTrainingData() {
		return trainingData;
	}
	/**
	 * @return the testData
	 */
	public DataSet getTestData() {
		return testData;
	}
	
}
