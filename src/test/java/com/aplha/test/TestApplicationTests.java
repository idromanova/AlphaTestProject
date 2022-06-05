package com.aplha.test;

import static org.junit.Assert.assertEquals;
import com.aplha.test.feighClients.GiphyClient;
import com.aplha.test.feighClients.RateClient;
import com.aplha.test.models.*;
import com.aplha.test.services.GiphyService;
import com.aplha.test.services.RateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.HashMap;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestApplicationTests {

	@MockBean
	RateClient rateClient;
	@MockBean
	GiphyClient giphyClient;

	@Autowired
	private RateService rateService;
	@Autowired
	private GiphyService giphyService;

	@Test
	void testRateServiceWithFalseResult() throws Exception {
		RateModel rateModel = new RateModel();
		HashMap<String, Double> testData = new HashMap<>();
		testData.put("AMD", 67.5);
		rateModel.setRates(testData);

		RateModel rateModel2 = new RateModel();
		HashMap<String, Double> testData2 = new HashMap<>();
		testData2.put("AMD", 67.8);
		rateModel2.setRates(testData2);

		Mockito.when(rateClient.getInfoByThisDay(Mockito.anyString())).thenReturn(rateModel);
		Mockito.when(rateClient.getInfoByPreviousDay(Mockito.anyString(),Mockito.anyString())).thenReturn(rateModel2);

		assertEquals(false, rateService.getRate("AMD"));
	}

	@Test
	void testRateServiceWithTrueResult() throws Exception {
		RateModel rateModel = new RateModel();
		HashMap<String, Double> testData = new HashMap<>();
		testData.put("AMD", 67.9);
		rateModel.setRates(testData);

		RateModel rateModel2 = new RateModel();
		HashMap<String, Double> testData2 = new HashMap<>();
		testData2.put("AMD", 67.5);
		rateModel2.setRates(testData2);

		Mockito.when(rateClient.getInfoByThisDay(Mockito.anyString())).thenReturn(rateModel);
		Mockito.when(rateClient.getInfoByPreviousDay(Mockito.anyString(),Mockito.anyString())).thenReturn(rateModel2);

		assertEquals(true, rateService.getRate("AMD"));
	}

	GiphyModel createModel(String url)
	{
		OriginalModel originalModel = new OriginalModel();
		originalModel.setUrl(url);

		ImageModel imageModel = new ImageModel();
		imageModel.setOriginal(originalModel);

		GiphyModel giphyModel = new GiphyModel();
		giphyModel.setImages(imageModel);

		return giphyModel;
	}

	@Test
	void testGiphyService() throws Exception {
		GiphyFullModel broke = new GiphyFullModel();
		broke.setData(createModel("https://media.giphy.com/media/1ppudqsvJAWPa63iLU/giphy.gif"));

		GiphyFullModel rich = new GiphyFullModel();
		rich.setData(createModel("https://media.giphy.com/media/SsTcO55LJDBsI/giphy.gif"));

		Mockito.when(giphyClient.getGIF("broke")).thenReturn(broke);
		Mockito.when(giphyClient.getGIF("rich")).thenReturn(rich);

		assertEquals("https://media.giphy.com/media/1ppudqsvJAWPa63iLU/giphy.gif", giphyService.getUrl(false));
		assertEquals("https://media.giphy.com/media/SsTcO55LJDBsI/giphy.gif", giphyService.getUrl(true));
	}
}
