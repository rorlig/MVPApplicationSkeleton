package com.rorlig;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import com.rorlig.common.TestDataFactory;
import com.rorlig.data.DataManager;
import com.rorlig.data.model.response.NamedResource;
import com.rorlig.data.model.response.Pokemon;
import com.rorlig.data.model.response.PokemonListResponse;
import com.rorlig.data.remote.PokemonService;
import com.rorlig.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by shivam on 29/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock
    private PokemonService mockPokemonService;

    private DataManager dataManager;

    @Before
    public void setUp() {
        dataManager = new DataManager(mockPokemonService);
    }

    @Test
    public void getPokemonListCompletesAndEmitsPokemonList() {
        List<NamedResource> namedResourceList = TestDataFactory.makeNamedResourceList(5);
        PokemonListResponse pokemonListResponse = new PokemonListResponse();
        pokemonListResponse.results = namedResourceList;

        when(mockPokemonService.getPokemonList(anyInt()))
                .thenReturn(Single.just(pokemonListResponse));

        dataManager
                .getPokemonList(10)
                .test()
                .assertComplete()
                .assertValue(TestDataFactory.makePokemonNameList(namedResourceList));
    }

    @Test
    public void getPokemonCompletesAndEmitsPokemon() {
        String name = "charmander";
        Pokemon pokemon = TestDataFactory.makePokemon(name);
        when(mockPokemonService.getPokemon(anyString())).thenReturn(Single.just(pokemon));

        dataManager.getPokemon(name).test().assertComplete().assertValue(pokemon);
    }
}
