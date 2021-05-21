package Remote;

import Model.Coin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinService {
    @GET("data/price")
    Call<Coin> calculatevalue(@Query("fsym") String from,@Query("tsyms") String to);
}
