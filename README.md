# ItemFrameCSV


Simple plugin that reads CSV files and converts it into Essentials Sign Shop.

Here you can see example how CSV file should look like.
Please avoid "", dot or , in amount and you should be fine!

Plugin was created for AvenMC (1.12.2)

You can modify, distribute, use at your own
but please don't claim it as yours.

If you want to contribute and add something create pull request.

Permissions:
- KItemFrame.loadsigns

Commands:
- /loadsigns - Loads Signs at offset (0, 1, 0), (0, -1, 0) from ItemFrames with item, be sure to follow CSV Requirements
                                        
#CSV Requirements
Name,ID:Data(If there is not data say :0),$Price,Amount   <- Buy Only


Name,ID:Data(If there is not data say :0),$Price,Amount,$PriceSell, AmounttoSell <- Buy/Sell

If You'll have any issues feel free to open issue, Enjoy
