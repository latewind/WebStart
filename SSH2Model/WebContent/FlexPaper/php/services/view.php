<?php
/**
* █▒▓▒░ The FlexPaper Project
*
* Copyright (c) 2009 - 2011 Devaldi Ltd
*
* When purchasing a commercial license, its terms substitute this license.
* Please see http://flexpaper.devaldi.com/ for further details.
*
*/

require_once("../lib/common.php");
require_once("../lib/pdf2swf_php5.php");
require_once("../lib/swfrender_php5.php");
require_once("../lib/pdf2json_php5.php");

	$doc 		= $_GET["doc"];
	$configManager 	= new Config();
	$callback	= "";

	if(!endsWith($doc,'.pdf')){$pdfdoc 	= $doc . ".pdf";}else{$pdfdoc 	= $doc;}
	if(isset($_GET["page"])){$page = $_GET["page"];}else{$page = "";}
	if(isset($_GET["format"])){$format=$_GET["format"];}else{$format="swf";}
	if($configManager->getConfig('splitmode')){$swfdoc 	= $pdfdoc . "_" . $page . ".swf";}else{$swfdoc 	= $pdfdoc . ".swf";}
	if(isset($_GET["callback"])){$callback = $_GET["callback"];}else{$callback = "";}
    if($configManager->getConfig('splitmode')){$jsondoc = $pdfdoc . "_" . $page . ".js";}else{$jsondoc = $pdfdoc . ".js";}
	if(isset($_GET["resolution"])){$resolution=$_GET["resolution"];}else{$resolution=null;}

	$pngdoc 		= $pdfdoc . "_" . $page . ".png";
	$jpgcachedoc 	= $pdfdoc . "_" . $page . "_res_" . $resolution . ".jpg";

	$messages 		= "";

	$swfFilePath 	= $configManager->getConfig('path.swf') . $swfdoc;
	$pdfFilePath 	= $configManager->getConfig('path.pdf') . $pdfdoc;
	$pngFilePath 	= $configManager->getConfig('path.swf') . $pngdoc;
	$jpgCachePath 	= $configManager->getConfig('path.swf') . $jpgcachedoc;
	$jsonFilePath 	= $configManager->getConfig('path.swf') . $jsondoc;
	$validatedConfig = true;

	session_start();

	if(!is_dir($configManager->getConfig('path.swf'))){
		Echo "Error:Cannot find SWF output directory, please check your configuration file";
		$validatedConfig = false;
	}

	if(!is_dir($configManager->getConfig('path.pdf'))){
		echo "Error:Cannot find PDF output directory, please check your configuration file";
		$validatedConfig = false;
	}

	if(!$validatedConfig){
		echo "Error:Cannot read directories set up in configuration file, please check your configuration.";
	}else if(	!validPdfParams($pdfFilePath,$pdfdoc,$page) /*|| !validSwfParams($swfFilePath,$swfdoc,$page) */){
		echo "Error:Incorrect file specified, please check your path";
	}else{
		if($format == "swf" || $format == "png" || $format == "pdf"){

			// converting pdf files to swf format
			if(!file_exists($swfFilePath)){
				$pdfconv=new pdf2swf();
				$messages=$pdfconv->convert($pdfdoc,$page);
			}

			// rendering swf files to png images
			if($format == "png"){
				if(validSwfParams($swfFilePath,$swfdoc,$page)){
					if(!file_exists($pngFilePath)){
						$pngconv=new swfrender();
						$pngconv->renderPage($pdfdoc,$swfdoc,$page);
					}

					if($configManager->getConfig('allowcache')){
						setCacheHeaders();
					}

					if(!$configManager->getConfig('allowcache') || ($configManager->getConfig('allowcache') && endOrRespond())){
						
						if($resolution!=null){
						header('Content-Type: image/jpeg');
							echo file_get_contents(generateImage($pngFilePath,$jpgCachePath,$resolution,'jpg'));
						}else{
							header('Content-Type: image/png');
							echo file_get_contents($pngFilePath);
						}
					}
				}else{
					if(strlen($messages)==0 || $messages == "[OK]")
						$messages = "[Incorrect file specified, please check your path]";
				}
			}

			// rendering pdf files to the browser
			if($format == "pdf"){
				header('Content-type: application/pdf');
				echo file_get_contents($pdfFilePath);
			}

			// writing files to output
			if(file_exists($swfFilePath)){
				if($format == "swf"){

					if($configManager->getConfig('allowcache')){
						setCacheHeaders();
					}

					if(!$configManager->getConfig('allowcache') || ($configManager->getConfig('allowcache') && endOrRespond())){
						header('Content-type: application/x-shockwave-flash');
						header('Accept-Ranges: bytes');
						header('Content-Length: ' . filesize($swfFilePath));
						echo file_get_contents($swfFilePath);
					}
				}
			}else{
				if(strlen($messages)==0)
					$messages = "[Cannot find SWF file. Please check your PHP configuration]";
			}
		}

		// for exporting pdf to json format
		if($format == "json" || $format == "jsonp"){
			if(!file_exists($jsonFilePath)){
				$jsonconv = new pdf2json();
				$messages=$jsonconv->convert($pdfdoc,$jsondoc,$page);
			}

			if(file_exists($jsonFilePath)){
				if($configManager->getConfig('allowcache')){
						setCacheHeaders();
				}

				if(!$configManager->getConfig('allowcache') || ($configManager->getConfig('allowcache') && endOrRespond())){
					header('Content-Type: text/javascript');

					if($format == "json"){
						echo file_get_contents($jsonFilePath);
					}

					if($format == "jsonp"){
						echo $callback. '('. file_get_contents($jsonFilePath) . ')';
					}
				}
			}else{
				if(strlen($messages)==0)
					$messages = "[Cannot find JSON file. Please check your PHP configuration]";
			}
		}

		// write any output messages
		if(strlen($messages)>0 && $messages != "[OK]" && $messages != "[Converted]" && $format != "png"){
			echo "Error:" . substr($messages,1,strlen($messages)-2);
		}
	}
?>