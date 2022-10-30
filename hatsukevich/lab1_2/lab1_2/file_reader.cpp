#include "file_reader.h"

File_reader::File_reader(QWidget *parent)
{

    //QWidget w;
    grid_layout = new QGridLayout;
    setLayout(grid_layout);

    text_edit = new QTextEdit;
    text_edit->setReadOnly(true);
    grid_layout->addWidget(text_edit, 0,0);

    button = new QPushButton;
    button->setText("Open file..");
    grid_layout->addWidget(button, 5, 0);

    //соединение сигнала и слота
    QObject::connect (button, SIGNAL(clicked(bool)), SLOT(openFile()));
}

int File_reader::openFile(){

    QString filename = QFileDialog::getOpenFileName();
    QFile file (filename);

    if (!file.open(QIODevice::ReadOnly)){ //С помощью метода open() открываем файл в режиме чтения
        qWarning("Cannot open file for reading"); // если файл не найден, то выводим предупреждение и завершаем выполнение программы
        return 1;
    }

    QTextStream in(&file); // Создаем входящий поток, из которого будут считываться данные, и связываем его с нашим файлом
    while(!in.atEnd()){ //метод atEnd() возвращает true, если в потоке больше нет данных для чтения
        QString line = in.readAll();
        text_edit->setText(line);
    }
    file.close();
}
