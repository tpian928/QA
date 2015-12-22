$(document).ready(function(){
	for(var i = 0; i < 1; i++) {
		var $tpl = $("#test");
		var source = $tpl.text();
		var template = Handlebars.compile(source);
		
		var data = {		
		user: 'David',
        title: '既然 AAC 要比 MP3 好，且体积差不多，为什么网上不流行 AAC 格式的音频呢？',
        description: '我试了下，将倉木麻衣.-.[もう一度].单曲.(APE) 无损格式分别转成AAC格式的（.m4a）和MP3格式，两者码率均是320kps。再用adobe audition查看了这三份文件的频谱',
		answer: '作为音频算法从业人员给出个答案。1、MP3能够火起来，明显不是广播，而是windows系统的火爆，windows系统出了支持wma外，还强有力地推动了mp3的发展。当年各位买mp3那个播放器的时候，从哪里导歌呢？还不是从windows啊。'

		};
		

		
		
		
		var html = template(data);
		console.log(html);
		$("#fp-main-container").append($(html));
	}
});