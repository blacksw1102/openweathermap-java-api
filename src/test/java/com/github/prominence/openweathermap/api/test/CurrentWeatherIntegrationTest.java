/*
 * Copyright (c) 2019 Alexey Zinchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.prominence.openweathermap.api.test;

import com.github.prominence.openweathermap.api.enums.Accuracy;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.Unit;
import com.github.prominence.openweathermap.api.model.Coordinate;
import com.github.prominence.openweathermap.api.model.CoordinateRectangle;
import com.github.prominence.openweathermap.api.model.Weather;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CurrentWeatherIntegrationTest extends ApiTest {

    @Test
    public void whenGetSingleCurrentWeatherByCoordinateRequestAsJava_thenReturnNotNull() {
        final Weather weather = getClient()
                .currentWeather()
                .single()
                .byCoordinate(new Coordinate(5, 5))
                .accuracy(Accuracy.ACCURATE)
                .language(Language.ROMANIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetSingleCurrentWeatherByCityIdRequestAsJava_thenReturnNotNull() {
        final Weather weather = getClient()
                .currentWeather()
                .single()
                .byCityId(350001514)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asJava();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetSingleCurrentWeatherByCityNameRequestAsJava_thenReturnNotNull() {
        final Weather weather = getClient()
                .currentWeather()
                .single()
                .byCityName("Minsk")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetSingleCurrentWeatherByCityNameAndCountryCodeRequestAsJava_thenReturnNotNull() {
        final Weather weather = getClient()
                .currentWeather()
                .single()
                .byCityName("Moscow", "ru")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetSingleCurrentWeatherByZipCodeAndCountryRequestAsJava_thenReturnNotNull() {
        final Weather weather = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetAnySingleCurrentRequestWeatherAsJson_thenReturnNotNull() {
        final String weatherJson = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJSON();

        assert weatherJson != null;
        System.out.println(weatherJson);
    }

    @Test
    public void whenGetAnySingleCurrentRequestWeatherAsXml_thenReturnNotNull() {
        final String weatherXml = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asXML();

        assert weatherXml != null;
        System.out.println(weatherXml);
    }

    @Test
    public void whenGetAnySingleCurrentWeatherRequestAsHtml_thenReturnNotNull() {
        final String weatherHtml = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asHTML();

        assert weatherHtml != null;
        System.out.println(weatherHtml);
    }

    @Test
    public void whenGetAnySingleCurrentWeatherAsyncRequestAsXml_thenReturnNotNull() {
        final CompletableFuture<String> weatherXmlFuture = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieveAsync()
                .asXML();

        assert weatherXmlFuture != null;
        weatherXmlFuture.thenAccept(System.out::println);
    }

    @Test
    public void whenGetAnySingleCurrentWeatherAsyncRequestAsJava_thenReturnNotNull() {
        final CompletableFuture<Weather> weatherFuture = getClient()
                .currentWeather()
                .single()
                .byZipCodeAndCountry("220015", "by")
                .language(Language.RUSSIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieveAsync()
                .asJava();

        assert weatherFuture != null;
        weatherFuture.thenAccept(System.out::println);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCoordinateRequestAsJava_thenReturnNotNull() {
        final List<Weather> weatherList = getClient()
                .currentWeather()
                .multiple()
                .byRectangle(new CoordinateRectangle(12, 32, 15, 37), 10)
                .accuracy(Accuracy.ACCURATE)
                .language(Language.ROMANIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weatherList != null;
        assert weatherList.size() > 0;
        System.out.println(weatherList);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCoordinateAndServerClusteringRequestAsJava_thenReturnNotNull() {
        final List<Weather> weatherList = getClient()
                .currentWeather()
                .multiple()
                .byRectangle(new CoordinateRectangle(12, 32, 15, 37), 10, true)
                .accuracy(Accuracy.ACCURATE)
                .language(Language.ROMANIAN)
                .unit(Unit.METRIC_SYSTEM)
                .retrieve()
                .asJava();

        assert weatherList != null;
        assert weatherList.size() > 0;
        System.out.println(weatherList);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCitiesInCycleRequestAsJava_thenReturnNotNull() {
        final List<Weather> weatherList = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asJava();

        assert weatherList != null;
        assert weatherList.size() > 0;
        System.out.println(weatherList);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCitiesInCycleAndServerClusteringRequestAsJava_thenReturnNotNull() {
        final List<Weather> weatherList = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10, true)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asJava();

        assert weatherList != null;
        assert weatherList.size() > 0;
        System.out.println(weatherList);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCitiesInCycleRequestAsJson_thenReturnNotNull() {
        final String weather = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asJSON();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCitiesInCycleRequestAsXml_thenReturnNotNull() {
        final String weather = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asXML();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCitiesInCycleRequestAsHtml_thenReturnNotNull() {
        final String weather = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieve()
                .asHTML();

        assert weather != null;
        System.out.println(weather);
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCoordinateAndServerClusteringAsyncRequestAsJava_thenReturnNotNull() {
        final CompletableFuture<List<Weather>> weatherListFuture = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10, true)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieveAsync()
                .asJava();

        assert weatherListFuture != null;
        weatherListFuture.thenAccept(result -> {
            assert result.size() > 0;
            System.out.println(result);
        });
    }

    @Test
    public void whenGetMultipleCurrentWeatherByCoordinateAndServerClusteringAsyncRequestAsXml_thenReturnNotNull() {
        final CompletableFuture<String> weatherFuture = getClient()
                .currentWeather()
                .multiple()
                .byCitiesInCycle(new Coordinate(55.5, 37.5), 10, true)
                .language(Language.GERMAN)
                .unit(Unit.IMPERIAL_SYSTEM)
                .retrieveAsync()
                .asXML();

        assert weatherFuture != null;
        weatherFuture.thenAccept(System.out::println);
    }
}
