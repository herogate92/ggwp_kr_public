<!--
            www.ggwp.kr@gmail.com
==================================================
  __ _  __ _                         _  _   __ _
 / _` |/ _` | __        __ __ _     | |/ / | '_ |
  (_| | (_| | \ \  __  / /| '_ |    | ' /  | |_)/
 \__, |\__, |  \ \/  \/ / | |_)| _  | . \  | ._ \ 
 |___/=|___/=   \__/\__/  | .__|(_) |_|\_\ |_| \_\
========================= |_|=====================
ZZZZZZZZZZZZZZZZZZZZZZZZZZE9ZZZZZZZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZZZZZz, DZ5    j9ZZZZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZ9j  wWzEEZZZZDW, ,zZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZZD   wyZZZDjW5Bwj9ZZBwwD9BZZZZZZZZZZZZZ
ZZZZZZZZZZZjwZZZZZZBWw8yDEE5WWBZZZy5BEZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZBWWjDZZZw8ZzZZZzWWyBZ95BZZZZZZZZZZZ
ZZZZZZZZZZZ    BZZZ5jwjzZZD wW5ZZZ8,  wZZZZZZZZZZZ
ZZZZZZZZZZZ yyw   WZZZ5jz9Z9ZEZy    BEZZZZZZZZZZZZ
ZZZZZZZZZZZ jj8ZEy    ZzDZ E5   WEZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZ jWDE5ZZ9z E ZDZyw,ZZZZZ8y ZZZZZZZZZZZZ
ZZZZZZZZZZZ yWDEZjEZZZZZ8 Z y Z Z  ,j ZZZZZZZZZZZZ
ZZZZZZZZZZZ yWjyZ   5zZBZ,Z 5 ZwZ DW5 ZZZZZZZZZZZZ
ZZZZZZZZZZZ wWZZZ89,j Z Z Z 5 ZDZZZwj ZZZZZZZZZZZZ
ZZZZZZZZZZZZ   wEZZw5 Z,Z Z 5,ZZEzw  yZZZZZZZZZZZZ
ZZZZZZZZZZZZZ5    ,W5 Z Z Z 5WW     8ZZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZZ8w    Z Z Z ,   yEZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZZZZZZW8ZZZZZB BZZZZZZZZZZZZZZZZZZZZ
ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ
ZZZZZZZEZZZZZZZZZZzZZZZZZZZZZZZZZZZZEZZZZZZZZZZZZZ
ZZZZB      ZZZZ      DZZB  ZZ   ZZ  8ZZy      ZZZZ
ZZZ9  ZZZZZZZZ  5ZZZZZZZZ, 9Z W ZE WZZZz ZZZ  ZZZZ
ZZZz  ZZB  zZZ  zZZD  ZZZZ ,, Z ww ZZZZz     BZZZZ
ZZZZW   W  8ZZZ    w  ZZZZ5  zZD  5ZZZZy jZZZZZZZZ
ZZZZZZZBDZZZZZZZZ8B8ZZZZZZZ5DZZZD5ZZZZZZ9ZZZZZZZZZ
-->
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="GGWP - Good Game Well Played! Best Game Clip">
    <meta name="author" content="www.ggwp.kr@gmail.com">
    <meta name="keyword" content="ggwp">

    <meta property="og:type" content="website">
    <meta property="og:url" content="https://www.ggwp.kr">
    <meta property="og:title" id="ogtitle" content="GGWP - Good Game Well Played! Best Game Clip">
    <meta property="og:description" id="ogdesc" content="GGWP - Good Game Well Played! Best Game Clip">
    <meta property="og:image" id="ogimg" content="https://www.ggwp.kr/img/logo.png">

    <title>GGWP - Good Game Well Played! Best Game Clip</title>
    <script data-ad-client="ca-pub-9882154897842516" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/all.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.min.css" />
    <!-- Custom styles for this template -->
    <!-- <link href="css/thumbnail-gallery.css" rel="stylesheet"> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/vanilla-lazyload@12.0.2/dist/lazyload.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script type="text/javascript">

    var $docFrag = $(document.createDocumentFragment());
//     var apiServerUrl = 'https://ggwp-kr.fastapi.shop/api/v1/';
    var apiServerUrl = "http://localhost:9081/api/v1/";
    
    function getClips(gameid)
    {
        var apiurl = apiServerUrl+'get/clip';
        if(gameid != 'all')
        {
            apiurl = apiServerUrl+'clip/game/'+gameid;
        }
        var $docFrag = $(document.createDocumentFragment());
        
        $.get(apiurl, function (data, status) {
		if ("success" == status) {
		    $.each(data, function (i, item) {
			var tempTag =
			'<div class="col-lg-3 col-md-4 col-6 thumb">'
			+'<div class="card" style="width: 100%;">'
			+'<a class="thumbnail" href="#" data-target="#clipModal" data-toggle="modal" data-title="'+ item.title +'" data-emburl="'+item.url +'">'
			+'<img class="card-img-top img-thumbnail img-fluid lazy" src="https://ggwp.kr/img/placeholder_ggwp_kr.png" data-src="'+ item.thumbnail_url +'" alt="">'
			+'<div class="card-body">'
			+'<h7 class="clip-card-title card-title">'+ item.title +'</h7></a>'
			+'</div></div></div>';
			$docFrag.append(tempTag);
		    });
		    $("#clipList").empty();
		    $("#clipList").append($docFrag);

		    var lazyLoadInstance = new LazyLoad({
				elements_selector: ".lazy"
		    });
		    if (lazyLoadInstance) {
				lazyLoadInstance.update();
		    }
		}
        });
    }
        $(document).ready(function (){
            getClips('all');
            $(".ctg").click(function(e,h ) {
                getClips(this.value);
            });

            $(".gamelistImg").click(function(e,h ) {
                getClips(this.value);
            });            

            $('#clipModal').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget);
				var demburl = button.data('emburl');
				var dtitle = button.data('title');
				var modal = $(this);
				modal.find('.modal-title').text(dtitle)
				modal.find('.modal-body #iframe-player').attr('src',demburl);
           	});

            $('#clipModal').on('hide.bs.modal', function (event) {
				var modal = $(this);
				modal.find('.modal-title').text('')
				modal.find('.modal-body #iframe-player').attr('src','');
           	});

			
			var $tempDoc = $(document.createDocumentFragment());
			$.ajax({
                url:apiServerUrl+'get/games/all',
                type: "GET",
                async: false,
                dataType: "json",
                success : function (data, status) {
                	if ("success" == status) {
                        $.each(data, function (i, item) {
                            var tempTag =
							'<a href="javascript:getClips('+item.idx+');" class="slickListGame" data-gameid="'+ item.idx +'">' 
                            +'<img class="gamelistImg img-fluid img-thumbnail lazy" src="https://ggwp.kr/img/placeholder_ggwp_kr.png"'
                            + 'data-src="' + item.boxArtUrl + '" alt="' + item.name+'"></a>';
                            $tempDoc.append(tempTag);
                        });
                        $('.slickList').append($tempDoc);
                        
	                	$(".slickList").slick({
	                        centerMode: true,
	                        centerPadding: '35px',
	                        dots: false,
	                        slidesToShow: 8,
	                        slidesToScroll: 8,
	                        arrows: true,
	                        infinite: true,
	                        adaptiveHeight: false,
	                        prevArrow:"<i class='fas fa-caret-left fa-5x a-left prev slick-prev'></i>",
	                        nextArrow:"<i class='fas fa-caret-right fa-5x a-right next slick-next'></i>"
	                    });
                    }
                },
				statusCode: {
					404: function() {
						alert( "page not found" );
					}
				}      
            });
        });
    </script>
    
    <!-- MAIN CSS -->
    <style>
        .main-logo {
            text-align: center;
        }
        
        .btn:focus, .btn:active, button:focus, button:active {
			  outline: none !important;
			  box-shadow: none !important;
			}
			
			#image-gallery .modal-footer{
			  display: block;
			}
			
			.thumb{
			  margin-top: 15px;
			  margin-bottom: 15px;
			}
		.clip-card-title{
			color: black;
    		font-weight: 600;
		}
		
		#slickSlideArea{
			position: relative;
		    display: block;
		    width: 80%;
		    margin:0 auto;
		}
 		.slickList > .slick-prev
		{
			position: absolute;
		    left: -5%;
		    color: lightgray;
		    top: 15%;
		}
		
		.slickList > .slick-next
		{
			position: absolute;
		    right: -5%;
		    color: lightgray;
		    top: 15%;
		}
    </style>
</head>
<body>
    <div class="container">
        <div class="main-logo">
            <a href="https://www.ggwp.kr"><img style="width: 125px;height: 125px;"
                    src="https://www.ggwp.kr/img/logo.png" /></a>
        </div>
        <hr/>
		<!-- TOP GAMES CATEGORY -->
        <button type="button" value="all" class="ctg btn btn-outline-primary">All</button>
        <button type="button" value="513143" class="ctg btn btn-outline-secondary">TFT</button>
        <button type="button" value="493057" class="ctg btn btn-outline-warning">PUBG</button>
        <button type="button" value="33214" class="ctg btn btn-outline-success">Fortnite</button>
        <button type="button" value="29595" class="ctg btn btn-outline-danger">DOTA2</button>
        <button type="button" value="460630" class="ctg btn btn-outline-warning">R6:Siege</button>
        <button type="button" value="21779" class="ctg btn btn-outline-info">LOL</button>
	    <button type="button" value="497057" class="ctg btn btn-outline-dark">Destiny2</button>
	    <button type="button" value="514790" class="ctg btn btn-outline-warning">LOR</button>
        <hr/>
        
		<!-- SLIDE LIST -->
        <div id="slickSlideArea" >
			<div class="slickList">
       		</div>
        </div>
        
		<!-- CLIP LIST -->
        <div id="clipList" class="row text-center text-lg-left">
       
        </div>
        
        <!-- MODAL AREA -->
        <div class="modal fade" id="clipModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="image-gallery-title"></h4>
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span>
                        </button>
                    </div>
                    <div class="modal-body">
<!-- 					   src="https://clips.twitch.tv/embed?clip=IncredulousAbstemiousFennelImGlitch" -->
	                   <iframe id="iframe-player"
	                   		src=""
							height="360"
							width="640"
							frameborder="0"
							scrolling="no"
							allowfullscreen="true">
						</iframe>
                        <img id="image-gallery-image" class="img-responsive col-md-12" src="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary float-left" id="show-previous-image"><i class="fa fa-arrow-left"></i>
                        </button>

                        <button type="button" id="show-next-image" class="btn btn-secondary float-right"><i class="fa fa-arrow-right"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; www.ggwp.kr@gmail.com</p>
                <p class="m-0 text-center text-white">
                    <a class="btn btn-github btn-outline-light" href="https://github.com/ggwp-kr/ggwp-kr.github.io"><i
                            class="fab fa-github fa-1x" aria-hidden="true"></i></a>
                    <a class="btn btn-outline-light" href="https://open.kakao.com/o/swJsgpsb"><i
                            class="fas fa-comment fa-1x"></i></a>
                </p>
            </div>
            <!-- /.container -->
        </footer>
    </div>
    
    <script type="text/javascript">
	</script>
</body>
</html>