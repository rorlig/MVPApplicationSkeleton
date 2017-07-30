package com.rorlig.features.detail;

import com.rorlig.data.model.response.Pokemon;
import com.rorlig.data.model.response.Statistic;
import com.rorlig.features.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);
}
