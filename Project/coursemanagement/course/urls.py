from django.urls import path 

from course import views 

urlpatterns = [
    path('hello-view/', views.HelloApiView.as_view()),
]