# План тестирования  
## Содержание    

1. [Введение](#par1) 
2. [Объект тестирования](#par2)
3. [Риски](#par3)
4. [Аспекты тестирования](#par4)
5. [Подходы к тестированию](#par5)
6. [Представление результатов](#par6)
7. [Выводы](#par7)

## <a name="par1">1. Введение</a>
Основная цель данного документа состоит в том, чтобы описать план тестирования desktop-приложение "EzAudioPlayer". 
Эта информация предназначена для команды, которая будет тестировать данное программное обеспечение на соответствие [требованиям](../docs/project_requirements.md).

## <a name="par2">2. Объект тестирования</a>
В качестве объекта тестирования следует выделить функциональное тестирование, а также тестирование удобства и простоты использования. 
К атрибутам качетсва относятся следующие характеристики:
1. Функциональная корректность.
2. Удобство использования.
3. Защищенность от ошибки пользователя.

## <a name="par3">3. Риски</a>
Приложение может работать только с файлами формата ".wav" и ".mp3". Текущая версия
Java SE на системе должна соответствовать версии в файле [README.md](../README.md).

## <a name="par4">4. Аспекты тестирования</a>
В процессе тестирования предполагается проверить соответствие системы требованиям, на основе которых она была спроектирована и 
реализована. Для данного проекта [основными функциями](../docs/project_requirements.md) являются следующие:
1. Приостановка воспроизведения
2. Старт / продолжение воспроизведения
3. Остановка воспроизведения
4. Контроль громкости звука
5. Контроль времени воспроизведения
6. Выбор аудиофайла для воспроизведения
      
Также необходимо проверить соответствие системы [нефункциональным требованиям](../docs/project_requirements.md):  
1. Производительность
2. Расширяемость

## <a name="par5">5. Подходы к тестированию</a>
Для тестирования приложения необходимо использовать ручное тестирование, чтобы проверить все аспекты тестирования. 
Для тестирования необходимо скачать на компьютер исполняющий файл "player.jar" из [player_jar](https://github.com/DanyaHDanny/EzAudioPlayer/tree/master/sourcecode/player/out/player_jar). 

## <a name="par6">6. Представление результатов</a>
Результаты тестирования представлены в документе ["Представление результатов"](TestResults.md).
## <a name="par7">7. Выводы</a>