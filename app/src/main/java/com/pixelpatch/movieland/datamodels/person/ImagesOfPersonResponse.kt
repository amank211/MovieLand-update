import com.google.gson.annotations.SerializedName

data class ImagesOfPersonResponse(
    val id: Long,
    val page: Long,
    val results: List<ImageResult>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)

data class ImageResult(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    @SerializedName("file_path")
    val filePath: String,
    val height: Long,
    val id: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
    val width: Long,
    @SerializedName("image_type")
    val imageType: String,
    val media: Media,
    @SerializedName("media_type")
    val mediaType: String,
)

data class Media(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    val title: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    val popularity: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
)
