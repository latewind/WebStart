; <?php exit; ?> DO NOT REMOVE THIS LINE
[requirements]
 test_pdf2swf				= true
 test_pdf2json				= false

[general]
 allowcache 				= true
 splitmode					= false
 path.pdf 					= "C:\inetpub\wwwroot\adaptiveui\pdf"
 path.swf 					= "C:\inetpub\wwwroot\adaptiveui\docs"
 renderingorder.primary 	= "flash"
 renderingorder.secondary 	= "html"

[external commands]
 cmd.conversion.singledoc 		= "pdf2swf.exe \"{path.pdf}{pdffile}\" -o \"{path.swf}{pdffile}.swf\" -f -T 9 -t -s storeallcharacters -s linknameurl"
 cmd.conversion.splitpages 		= "pdf2swf.exe \"{path.pdf}{pdffile}\" -o \"{path.swf}{pdffile}%.swf\" -f -T 9 -t -s storeallcharacters -s linknameurl"
 cmd.conversion.renderpage 		= "swfrender.exe \"{path.swf}{swffile}\" -p {page} -o \"{path.swf}{pdffile}_{page}.png\" -X 1024 -s keepaspectratio"
 cmd.conversion.rendersplitpage	= "swfrender.exe \"{path.swf}{swffile}\" -o \"{path.swf}{pdffile}_{page}.png\" -X 1024 -s keepaspectratio"
 cmd.conversion.jsonfile		= "pdf2json.exe \"{path.pdf}{pdffile}\" -enc UTF-8 -compress \"{path.swf}{jsonfile}\"" 
 cmd.searching.extracttext 		= "swfstrings.exe \"{swffile}\""
 cmd.query.swfwidth				= "swfdump.exe \"{swffile}\" -X"
 cmd.query.swfheight			= "swfdump.exe \"{swffile}\" -Y"
