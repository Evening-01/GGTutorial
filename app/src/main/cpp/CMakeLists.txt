cmake_minimum_required(VERSION 3.22.1)

project("tutorial")

include_directories(util)
include_directories(test)

file(GLOB BASIC_SRCS "step/basic/*.cpp")
file(GLOB AGG_SRCS "step/agg/*.cpp")
file(GLOB PRACTICAL_SRCS "step/practical/*.cpp")

add_library(${CMAKE_PROJECT_NAME} SHARED
        main/tutorial-lib.cpp
        ${BASIC_SRCS}
        ${AGG_SRCS}
        ${PRACTICAL_SRCS}
)

target_link_libraries(${CMAKE_PROJECT_NAME}
        android
        log
)
